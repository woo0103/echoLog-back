package com.deli.echolog.dto.diary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 일기 생성할 때 받는 dto
public class DiaryCreateRequestDto {
    Long memberId;
    String content;

}
