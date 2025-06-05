package com.deli.echolog.service;

import com.deli.echolog.domain.Depression;
import com.deli.echolog.domain.Diary;
import com.deli.echolog.dto.depression.DepressionJsonResponseDto;
import com.deli.echolog.exception.DepressionNotFoundException;
import com.deli.echolog.python.DepressionSession;
import com.deli.echolog.repository.DepressionRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class DepressionService {

    private final DepressionRepository depressionRepository;

    @Transactional(readOnly = true)
    public Depression getDepression(Long depressionId) {
        return depressionRepository.findById(depressionId)
                .orElseThrow(() -> new DepressionNotFoundException("depression not found"));
    }

    public Depression saveDepression(Depression depression) {
        return depressionRepository.save(depression);
    }

    public Depression updateDepression(Long depressionId, boolean result, double emotionScore, double depressionWordScore, double phq9Score, double gad7Score) {
        Depression depression = getDepression(depressionId);
        depression.update(result, emotionScore, depressionWordScore, phq9Score, gad7Score);
        return depression;
    }

    public void deleteDepression(Long depressionId) {
        Diary diary = getDepression(depressionId).getDiary();
        diary.changeDepression(null);
    }

    public Depression analyzeDepression(List<Diary> diaryList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<Map<String, String>> items = diaryList.stream().map(diary -> {
                Map<String, String> map = new HashMap<>();
                map.put("log", diary.getTransformDiary().getContent());
                map.put("emotion", diary.getEmotion().getEmotionType().name());
                return map;
            }).toList();

            String inputJson = objectMapper.writeValueAsString(Map.of("items", items));
            log.info("파이썬에 전달할 JSON: {}", inputJson);

            String jsonOutput = DepressionSession.analyze(inputJson);
            log.info("파이썬 결과 수신: {}", jsonOutput);

            // JSON 중첩된 "result" 키에서 추출
            JsonNode rootNode = objectMapper.readTree(jsonOutput);
            JsonNode resultNode = rootNode.get("result");
            DepressionJsonResponseDto result = objectMapper.treeToValue(resultNode, DepressionJsonResponseDto.class);

            double emotionScore = result.getEmotionScore();
            double depressionWordScore = result.getDepressionWordScore();
            double phq9Score = result.getPhq9Score();
            double gad7Score = result.getGad7Score();

            boolean analyzedResult = (emotionScore + depressionWordScore + phq9Score + gad7Score) >= 20.0;

            Depression depression = new Depression();
            depression.update(analyzedResult, emotionScore, depressionWordScore, phq9Score, gad7Score);
            Depression saved = saveDepression(depression);

            // 마지막 일기에 연관관계 설정
            diaryList.get(diaryList.size() - 1).changeDepression(saved);

            return saved;

        } catch (Exception e) {
            log.error("우울증 분석 실패", e);
            throw new RuntimeException("우울증 분석 중 예외 발생", e);
        }
    }
}
