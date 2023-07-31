package me.youngeun.practice1.test1.service;

import lombok.RequiredArgsConstructor;
import me.youngeun.practice1.test1.model.Member;
import me.youngeun.practice1.test1.model.dto.MemberRequestDto;
import me.youngeun.practice1.test1.model.dto.MemberResponseDto;
import me.youngeun.practice1.test1.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResponseDto signup(MemberRequestDto requestDto) {

        if(memberRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 사용자입니다");
        }
        Member member = requestDto.toMember(passwordEncoder);
        member = memberRepository.save(member);
        return MemberResponseDto.of(member);
    }
}
