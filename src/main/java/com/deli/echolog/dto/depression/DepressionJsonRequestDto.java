package com.deli.echolog.dto.depression;

import com.deli.echolog.domain.EmotionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepressionJsonRequestDto {

    private EmotionType emotionType;
    private String content;
}
