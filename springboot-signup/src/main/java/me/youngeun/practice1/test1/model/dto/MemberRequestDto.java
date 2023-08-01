package me.youngeun.practice1.test1.model.dto;

import lombok.*;
import me.youngeun.practice1.test1.model.Member;
import me.youngeun.practice1.test1.model.enums.Authority;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequestDto {
    private String email;
    private String password;

    // 회원 정보
    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
//                .authority(Authority.ROLE_USER)
                .build();
    }

    public MemberResponseDto toMemberResponseDto(MemberRequestDto memberRequestDto) {
        return MemberResponseDto.builder()
                .email(email)
                .build();
    }
}
