package com.survey.member.Repository;

import com.survey.member.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// <entity name, pk type>
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    // 이메일로 회원 정보 조회
    Optional<MemberEntity> findByUserEmail(String userEmail);
}
