package com.deli.echolog.dto.emotion;

import com.deli.echolog.domain.Emotion;
import com.deli.echolog.domain.EmotionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class EmotionResponseDto {
    private EmotionType emotionType;
    private Double intensity;

    public static EmotionResponseDto from(Emotion emotion) {
        return new EmotionResponseDto(
                emotion.getEmotionType(), emotion.getIntensity()
        );
    }
}
