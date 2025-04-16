package com.deli.echolog.dto.diary;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.Emotion;
import com.deli.echolog.domain.EmotionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
// 일기 목록 반환할때 쓰는 Dto
// 일기 생성일자도 반환해야되나?
public class DiaryListResponseDto {

    private Long diaryId;
    private LocalDateTime createDate;
    private EmotionType emotionType;

    /**
     * 일기를 Dto로 바꾸는 메서드임
     * @param diary
     * @return DiaryListResponseDto
     */
    public static DiaryListResponseDto from(Diary diary) {

        // null 처리
        Emotion emotion = diary.getEmotion();
        EmotionType emotionType = (emotion != null) ? emotion.getEmotionType() : null;

        return new DiaryListResponseDto(
                diary.getId(), diary.getCreateDate(), emotionType
        );
    }
}
