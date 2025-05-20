package com.deli.echolog.service;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.TransformDiary;
import com.deli.echolog.exception.TransformDiaryNotFoundException;
import com.deli.echolog.python.TransformSession;
import com.deli.echolog.repository.TransformDiaryRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class TransformDiaryService {

    private final TransformDiaryRepository transformDiaryRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // 변환된 일기 조회
    @Transactional(readOnly = true)
    public TransformDiary getTransformDiary(Long transformDiaryId) {
        return transformDiaryRepository.findById(transformDiaryId)
                .orElseThrow(() -> new TransformDiaryNotFoundException("transformDiary not found"));
    }

    // 단순 저장
    public TransformDiary saveTransformDiary(TransformDiary transformDiary) {
        return transformDiaryRepository.save(transformDiary);
    }

    // 변환된 일기 수정
    public TransformDiary updateTransformDiary(Long transformDiaryId, String content) {
        TransformDiary transformDiary = getTransformDiary(transformDiaryId);
        transformDiary.update(content);
        return transformDiary;
    }

    // 변환된 일기 삭제
    public void deleteTransformDiary(Long transformDiaryId) {
        TransformDiary transformDiary = getTransformDiary(transformDiaryId);
        transformDiary.getDiary().changeTransformDiary(null);
    }

    // 변환된 일기 분석
    public TransformDiary transform(Diary diary) {
        String content = diary.getContent();

        try {
            String responseJson = TransformSession.transform(content);
            String transformedText = parseTransformedContent(responseJson);

            TransformDiary transformDiary = new TransformDiary();
            transformDiary.update(transformedText);

            TransformDiary saved = saveTransformDiary(transformDiary);
            diary.changeTransformDiary(saved);
            return saved;

        } catch (Exception e) {
            throw new RuntimeException("일기 변환 실패", e);
        }
    }

    // JSON 파싱 헬퍼
    private String parseTransformedContent(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            return root.get("transformed").asText();
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON 파싱 실패: " + json, e);
        }
    }
}
