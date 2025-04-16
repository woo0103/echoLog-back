package com.deli.echolog.service;

import com.deli.echolog.domain.Depression;
import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.Emotion;
import com.deli.echolog.domain.EmotionType;
import com.deli.echolog.exception.DepressionNotFoundException;
import com.deli.echolog.exception.EmotionNotFoundException;
import com.deli.echolog.repository.DiaryRepository;
import com.deli.echolog.repository.EmotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class EmotionService {

    // 생성자 주입
    private final EmotionRepository emotionRepository;
    private final DiaryRepository diaryRepository;

    // 감정 조회
    public Emotion getEmotion(Long emotionId) {
        return emotionRepository.findById(emotionId)
                .orElseThrow(() -> new EmotionNotFoundException("emotion not found"));
    }

    // 감정 저장
    @Transactional
    public Emotion createEmotion(Diary diary) {
        Emotion emotion = analyzeEmotion(diary);
        return emotionRepository.save(emotion);

    }

    // 감정 수정
    @Transactional
    public Emotion updateEmotion(Long emotionId, EmotionType emotionType, Double intensity) {
        Emotion emotion = getEmotion(emotionId);
        emotion.update(emotionType, intensity);
        return emotion;
    }

    // 감정 삭제
    @Transactional
    public void deleteEmotion(Long emotionId) {
        emotionRepository.deleteById(emotionId);
    }


    // 감정 분석
    @Transactional
    public Emotion analyzeEmotion(Diary diary) {

        // AI 연결해서 분석하는 로직
        // AI가 반환했다고 침
        // 지금은 임의로 반환
        Emotion emotion = new Emotion();
        emotion.update(EmotionType.ANGRY, 10.0);
        diary.changeEmotion(emotion);
        diaryRepository.save(diary);
        return emotion;
    }
}
