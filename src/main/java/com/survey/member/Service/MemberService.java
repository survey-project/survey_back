package com.survey.member.Service;

import com.survey.member.DTO.MemberDTO;
import com.survey.member.Entity.MemberEntity;
import com.survey.member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
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
        Optional<MemberEntity> byUserEmail = memberRepository.findByUserEmail(memberDTO.getUserEmail());
        if (byUserEmail.isPresent()) {
           MemberEntity memberEntity = byUserEmail.get();
           if(memberEntity.getUserPw().equals(memberDTO.getUserPw())) {
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

    // 회원 목록 출력
    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity memberEntity: memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
            memberDTOList.add(memberDTO);
        }
        return memberDTOList;
    }

    // 회원번호 상세조회
    public MemberDTO findById(String id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()) {
            //MemberEntity memberEntity = optionalMemberEntity.get();
            //MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
            //return memberDTO;
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    // 회원정보 수정하기
    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByUserEmail(myEmail);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
         memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
    }

    // 회원 삭제
    public void deleteById(String id) {
        memberRepository.deleteById(id);
    }


}
