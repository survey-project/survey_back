package com.survey.member.Service;

import com.survey.member.DTO.MemberDTO;
import com.survey.member.Entity.MemberEntity;
import com.survey.member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void signup(MemberDTO memberDTO){
        // repositoy의 signup호출 (조건 : entity 객체 넘겨주기)
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity); //insert 쿼리 만들어주는 함수
    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 학번으로 DB에서 조회
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
         Optional<MemberEntity> byUserNum = memberRepository.findByUserNum(memberDTO.getUserNum());
        if (byUserNum.isPresent()) {
           MemberEntity memberEntity = byUserNum.get();
           if(memberEntity.getUserNum() == memberDTO.getUserNum()) {
             // entity -> dto 변환 -> return
               MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
               return dto;
           }else {
                return null;
           }
        } else {
            return null;
        }
    }
}
