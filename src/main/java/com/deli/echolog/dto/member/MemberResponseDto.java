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


    Long memberId;
    String name;
    String email;
    Role role;
    LocalDate birthDate;
    String phone;

    public static MemberResponseDto from(Member member) {
        return new MemberResponseDto(
                member.getId(), member.getName(), member.getEmail(), member.getRole(), member.getBirthDate(), member.getPhone()
        );
    }
}
