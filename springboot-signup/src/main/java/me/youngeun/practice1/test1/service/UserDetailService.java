package me.youngeun.practice1.test1.service;

import lombok.RequiredArgsConstructor;
import me.youngeun.practice1.test1.model.Member;
import me.youngeun.practice1.test1.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public Member loadUserByUsername(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}

