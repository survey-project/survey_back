package com.member.Repository;

import com.member.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// <entity name, pk type>
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 학번으로 회원 정보 조회
    Optional<MemberEntity> findByUserNum(int userNum);
}
