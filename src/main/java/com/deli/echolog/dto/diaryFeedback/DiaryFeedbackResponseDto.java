package com.deli.echolog.dto.diaryFeedback;

import com.deli.echolog.domain.DiaryFeedback;
import com.deli.echolog.domain.UserReaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiaryFeedbackResponseDto {

    private Long diaryFeedbackId;
    private String content;
    private UserReaction userReaction;

    public static DiaryFeedbackResponseDto from(DiaryFeedback diaryFeedback) {
        return new DiaryFeedbackResponseDto(
                diaryFeedback.getId(), diaryFeedback.getContent(), diaryFeedback.getUserReaction()
        );
    }
}
