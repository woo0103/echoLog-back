package com.deli.echolog.dto.diaryFeedback;

import com.deli.echolog.domain.UserReaction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryFeedbackUpdateRequestDto {

    private String content;
    private UserReaction userReaction;
}
