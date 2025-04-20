package com.deli.echolog.service;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.DiaryFeedback;
import com.deli.echolog.domain.EmotionType;
import com.deli.echolog.domain.UserReaction;
import com.deli.echolog.exception.DiaryFeedbackNotFoundException;
import com.deli.echolog.repository.DiaryFeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class DiaryFeedbackService {

    private final DiaryFeedbackRepository diaryFeedbackRepository;

    // 조회
    @Transactional(readOnly = true)
    public DiaryFeedback getDiaryFeedback(Long diaryFeedbackId) {
        return diaryFeedbackRepository.findById(diaryFeedbackId)
                .orElseThrow(() -> new DiaryFeedbackNotFoundException("diaryFeedback not found"));
    }

    // 저장
    public DiaryFeedback saveDiaryFeedback(DiaryFeedback diaryFeedback) {
        return diaryFeedbackRepository.save(diaryFeedback);
    }

    // 수정
    public DiaryFeedback updateDiaryFeedback(Long diaryFeedbackId, String content, UserReaction userReaction) {
        DiaryFeedback diaryFeedback = getDiaryFeedback(diaryFeedbackId);
        diaryFeedback.update(content, userReaction);
        return diaryFeedback;
    }

    // 삭제
    public void deleteDiaryFeedback(Long diaryFeedbackId) {
        DiaryFeedback diaryFeedback = getDiaryFeedback(diaryFeedbackId);
        diaryFeedback.getDiary().changeDiaryFeedback(null);
    }

    // 분석
    public DiaryFeedback generateFeedback(Diary diary) {
        // AI가 어쩌구
        // content, emotionType
        // 수치 4개
        EmotionType emotionType = diary.getEmotion().getEmotionType();
        String transformContent = diary.getTransformDiary().getContent();
        DiaryFeedback diaryFeedback = new DiaryFeedback();
        diaryFeedback.update("그래그래 참 잘했구나", UserReaction.LIKE);

        DiaryFeedback saved = saveDiaryFeedback(diaryFeedback);
        diary.changeDiaryFeedback(saved);
        return saved;
    }
}
