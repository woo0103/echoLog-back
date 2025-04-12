package com.deli.echolog.dto.diary;

import com.deli.echolog.domain.*;
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




    public DiaryResponseDto(Long diaryId, Long memberId, String content) {
        this.diaryId = diaryId;
        this.memberId = memberId;
        this.content = content;
    }

    /**
     * 일기를 Dto로 바꾸는 메서드임
     * @param diary 일기
     * @return DiaryResponseDto
     */
    public static DiaryResponseDto from(Diary diary) {
        // nullPointException 터져서 노가다로 처리함
        TransformDiary transformDiary = diary.getTransformDiary();
        Long transformDiaryId = (transformDiary != null) ? transformDiary.getId() : null;
        String transformContent = (transformDiary != null) ? transformDiary.getContent() : null;

        Emotion emotion = diary.getEmotion();
        Long emotionId = (emotion != null) ? emotion.getId() : null;

        DiaryFeedback diaryFeedback = diary.getDiaryFeedback();
        Long diaryFeedbackId = (diaryFeedback != null) ? diaryFeedback.getId() : null;

        Depression depression = diary.getDepression();
        Long depressionId = (depression != null) ? depression.getId() : null;

        return new DiaryResponseDto(
                diary.getId(), diary.getMember().getId(), diary.getContent(), transformDiaryId,
                transformContent, emotionId, diaryFeedbackId, depressionId);
    }
}
