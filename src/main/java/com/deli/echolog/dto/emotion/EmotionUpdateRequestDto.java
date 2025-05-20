package com.deli.echolog.dto.emotion;

import com.deli.echolog.domain.EmotionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmotionUpdateRequestDto {
    private EmotionType emotionType;
}
