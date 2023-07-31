package me.youngeun.practice1.test1.repository;

import me.youngeun.practice1.test1.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이메일 존재여부 확인
    boolean existsByEmail(String email);
    Optional<Member> findByEmail(String email);
}
