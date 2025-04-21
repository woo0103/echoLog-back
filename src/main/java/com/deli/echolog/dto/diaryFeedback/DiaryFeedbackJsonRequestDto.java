package com.deli.echolog.dto.diaryFeedback;

import com.deli.echolog.domain.EmotionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaryFeedbackJsonRequestDto {

    private EmotionType emotionType;
    private String content;
}
