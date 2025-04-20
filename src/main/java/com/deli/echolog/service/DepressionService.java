package com.deli.echolog.service;

import com.deli.echolog.domain.Depression;
import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.EmotionType;
import com.deli.echolog.exception.DepressionNotFoundException;
import com.deli.echolog.exception.DiaryNotFoundException;
import com.deli.echolog.repository.DepressionRepository;
import com.deli.echolog.repository.DiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DepressionService {

    private final DepressionRepository depressionRepository;

    // 우울증 분석 조회
    @Transactional(readOnly = true)
    public Depression getDepression(Long depressionId) {
        // id에 해당하는 일기가 없으면 예외 던짐
        return depressionRepository.findById(depressionId)
                .orElseThrow(() -> new DepressionNotFoundException("depression not found"));
    }



    // 우울증 분석 정보 넘어온 거 그대로 저장
    public Depression saveDepression(Depression depression) {
        return depressionRepository.save(depression);
    }

    // 우울증 분석 수정
    public Depression updateDepression(Long depressionId, String content, Double emotionScore, Double depressionWordScore, Double phq9Score) {
        Depression depression = getDepression(depressionId);
        depression.update(content, emotionScore, depressionWordScore, phq9Score);
        return depression;
    }

    // 우울증 분석 삭제
    public void deleteDepression(Long depressionId) {
        Diary diary = getDepression(depressionId).getDiary();
        diary.changeDepression(null);
    }


    // 우울증 분석 메서드
    // 일기 정보를 받아서 우울증 분석 반환
    // 연관관계도 여기서 설정함
    public Depression analyzeDepression(Diary diary) {
        // AI 연결해서 분석하는 로직
        // AI가 반환했다고 침
        EmotionType emotionType = diary.getEmotion().getEmotionType();
        String transformContent = diary.getTransformDiary().getContent();
        Depression depression = new Depression();
        depression.update("AI가 해줄거임", 10.0, 10.0, 10.0);
        // 연관관계 설정 전에 저장
        Depression saved = saveDepression(depression);
        diary.changeDepression(saved);
        return saved;
    }
}
