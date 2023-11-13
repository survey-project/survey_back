package com.survey.member.DTO;

import com.survey.member.Entity.MemberEntity;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Long userNo;
    private String userEmail;
    private String userPw;
    private String userGender;
    private String userDep;
    private int userGrade;
    private int userNum;
    private String userType;
    private Timestamp userDate;
    private String userName;
    private String userNick;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserNo(memberEntity.getUserNo());
        memberDTO.setUserEmail(memberEntity.getUserEmail());
        memberDTO.setUserPw(memberEntity.getUserPw());
        memberDTO.setUserGender(memberEntity.getUserGender());
        memberDTO.setUserDep(memberEntity.getUserDep());
        memberDTO.setUserGrade(memberEntity.getUserGrade());
        memberDTO.setUserNum(memberEntity.getUserNum());
        memberDTO.setUserType(memberEntity.getUserType());
        memberDTO.setUserDate(memberEntity.getUserDate());
        memberDTO.setUserName(memberEntity.getUserName());
        memberDTO.setUserNick(memberEntity.getUserNick());

        return memberDTO;
    }


}
