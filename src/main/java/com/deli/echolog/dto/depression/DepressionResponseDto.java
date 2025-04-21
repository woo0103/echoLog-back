package com.deli.echolog.dto.depression;

import com.deli.echolog.domain.Depression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// 우울증 분석 반환할 때 쓰는 Dto임
public class DepressionResponseDto {
    private Long depressionId;
    private String content;
    private Double emotionScore;
    private Double depressionWordScore;
    private Double phq9Score;
    private Double gad7Score;

    public static DepressionResponseDto from(Depression depression) {
        return new DepressionResponseDto(
                depression.getId(), depression.getContent(), depression.getEmotionScore(), depression.getDepressionWordScore(), depression.getPhq9Score(), depression.getGad7Score()
        );

    }
}


