package com.deli.echolog.dto.member;

import com.deli.echolog.domain.Member;
import com.deli.echolog.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class MemberResponseDto {


    private Long memberId;
    private String name;
    private String email;
    private Role role;
    private LocalDate birthDate;
    private String phone;

    public static MemberResponseDto from(Member member) {
        return new MemberResponseDto(
                member.getId(), member.getName(), member.getEmail(), member.getRole(), member.getBirthDate(), member.getPhone()
        );
    }
}
