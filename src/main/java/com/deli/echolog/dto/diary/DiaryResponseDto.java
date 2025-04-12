package com.deli.echolog.dto.diary;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.TransformDiary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiaryResponseDto {

    Long diaryId;
    Long memberId;
    String content;
    Long transformDiaryId;
    String transformContent;
    Long emotionId;
    Long diaryFeedbackId;
    Long depressionId;

    // diary -> dto 변환해서 반환


    public DiaryResponseDto(Long diaryId, Long memberId, String content) {
        this.diaryId = diaryId;
        this.memberId = memberId;
        this.content = content;
    }

    public static DiaryResponseDto from(Diary diary) {
        TransformDiary transformDiary = diary.getTransformDiary();

        return new DiaryResponseDto(
                diary.getId(), diary.getMember().getId(), diary.getContent()
        );
    }
}
