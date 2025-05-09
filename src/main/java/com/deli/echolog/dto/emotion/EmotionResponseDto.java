package com.deli.echolog.dto.emotion;

import com.deli.echolog.domain.Emotion;
import com.deli.echolog.domain.EmotionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class EmotionResponseDto {
    private Long emotionId;
    private EmotionType emotionType;

    public static EmotionResponseDto from(Emotion emotion) {
        return new EmotionResponseDto(
                emotion.getId(), emotion.getEmotionType()
        );
    }
}
