package com.deli.echolog.dto.depression;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepressionUpdateRequestDto {

    private Boolean result;
    private Double emotionScore;
    private Double depressionWordScore;
    private Double phq9Score;
    private Double gad7Score;
}
