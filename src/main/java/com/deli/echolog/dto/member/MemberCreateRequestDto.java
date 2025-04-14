package com.deli.echolog.dto.member;

import com.deli.echolog.domain.Member;
import com.deli.echolog.domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MemberCreateRequestDto {

    private String name;
    private String email;
    private String password;
    private Role role;
    private LocalDate birthDate;
    private String phone;

    public Member toEntity() {
        return new Member(
                this.name, this.email, this.password, this.role, this.birthDate, this.phone
        );
    }

}
