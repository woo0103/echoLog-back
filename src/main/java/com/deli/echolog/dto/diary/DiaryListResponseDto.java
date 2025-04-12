package com.deli.echolog.dto.diary;

import com.deli.echolog.domain.Diary;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryListResponseDto {

    Long diaryId;
    String emotionType;

    public DiaryListResponseDto(Long diaryId) {
        this.diaryId = diaryId;
    }

    public static DiaryListResponseDto from(Diary diary) {
        return new DiaryListResponseDto(
                diary.getId()
        );
    }
}
