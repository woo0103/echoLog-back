package com.deli.echolog.service;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.TransformDiary;
import com.deli.echolog.exception.TransformDiaryNotFoundException;
import com.deli.echolog.repository.TransformDiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class TransformDiaryService {

    private final TransformDiaryRepository transformDiaryRepository;

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
        // AI가 어쩌구
        // content -> content
        String content = diary.getContent();
        TransformDiary transformDiary = new TransformDiary();
        transformDiary.update("오늘 하루 어쩌구");

        // 먼저 저장
        TransformDiary saved = saveTransformDiary(transformDiary);
        diary.changeTransformDiary(saved);
        return saved;
    }

}
