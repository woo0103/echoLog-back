package com.deli.echolog.dto.emotion;

import com.deli.echolog.domain.EmotionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmotionJsonResponseDto {
    private EmotionType emotionType;
}
