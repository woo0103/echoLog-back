package com.deli.echolog.dto.notice;

import com.deli.echolog.domain.Member;
import com.deli.echolog.domain.Notice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeCreateRequestDto {

    private String title;
    private String content;

}
