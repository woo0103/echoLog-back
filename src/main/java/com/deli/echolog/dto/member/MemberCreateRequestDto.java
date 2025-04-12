package com.deli.echolog.dto.member;

import com.deli.echolog.domain.Member;
import com.deli.echolog.domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MemberCreateRequestDto {

    String name;
    String email;
    String password;
    Role role;
    LocalDate birthDate;
    String phone;

    public Member toEntity() {
        return new Member(
                this.name, this.email, this.password, this.role, this.birthDate, this.phone
        );
    }

}
