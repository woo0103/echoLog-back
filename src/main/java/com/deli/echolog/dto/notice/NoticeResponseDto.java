package com.deli.echolog.dto.notice;

import com.deli.echolog.domain.Member;
import com.deli.echolog.domain.Notice;
import com.deli.echolog.dto.member.MemberResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NoticeResponseDto {

    private Long noticeId;
    private String title;
    private String content;
    private String writer;

    public static NoticeResponseDto from(Notice notice) {
        return new NoticeResponseDto(
                notice.getId(), notice.getTitle(), notice.getContent(), notice.getWriter()
        );
    }

}
