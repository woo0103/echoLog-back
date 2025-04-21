package com.deli.echolog.dto.depression;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepressionJsonResponseDto {

    // 감정 점수
    private double emotionScore;

    // 우울 단어 점수
    private double depressionWordScore;

    // phq9 점수
    private double phq9Score;

    // GAD-7 점수
    private double gad7Score;
}
