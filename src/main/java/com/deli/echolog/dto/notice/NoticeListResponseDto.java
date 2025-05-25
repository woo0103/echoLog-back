package com.deli.echolog.dto.notice;

import com.deli.echolog.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NoticeListResponseDto {

    private Long noticeId;
    private String title;

    public static NoticeListResponseDto from(Notice notice) {
        return new NoticeListResponseDto(
                notice.getId(), notice.getTitle()
        );
    }

}
