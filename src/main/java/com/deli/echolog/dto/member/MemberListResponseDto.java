package com.deli.echolog.dto.member;

import com.deli.echolog.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberListResponseDto {

    private Long memberId;
    private String name;
    private String email;

    public static MemberListResponseDto from(Member member) {
        return new MemberListResponseDto(
                member.getId(), member.getName(), member.getEmail()
        );
    }
}
