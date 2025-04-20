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
@Transactional
public class EmotionService {

    // 생성자 주입
    private final EmotionRepository emotionRepository;
    private final DiaryRepository diaryRepository;

    @Transactional(readOnly = true)
    // 감정 조회
    public Emotion getEmotion(Long emotionId) {
        return emotionRepository.findById(emotionId)
                .orElseThrow(() -> new EmotionNotFoundException("emotion not found"));
    }


    // 감정 분석 정보 넘어온 거 그대로 저장
    public Emotion saveEmotion(Emotion emotion) {
        return emotionRepository.save(emotion);
    }

    // 감정 수정
    public Emotion updateEmotion(Long emotionId, EmotionType emotionType, Double intensity) {
        Emotion emotion = getEmotion(emotionId);
        emotion.update(emotionType);
        return emotion;
    }

    // 감정 삭제
    public void deleteEmotion(Long emotionId) {
        Emotion deleteEmotion = getEmotion(emotionId);
        deleteEmotion.getDiary().changeEmotion(null);
    }


    // 감정 분석
    public Emotion analyzeEmotion(Diary diary) {
        // AI 연결해서 분석하는 로직
        // AI가 반환했다고 침
        // 지금은 임의로 반환
        // 변환된 일기 내용
        String transformContent = diary.getTransformDiary().getContent();

        Emotion emotion = new Emotion();
        emotion.update(EmotionType.ANGRY);
        // 연관관계 설정 전에 저장
        Emotion saved = saveEmotion(emotion);
        diary.changeEmotion(saved);
        return saved;
    }
}
