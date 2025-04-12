package com.deli.echolog.dto.diary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 일기 수정할 때 받는 dto
public class DiaryUpdateRequestDto {
    String content;
}
