package com.survey.member.Entity;

import com.survey.member.DTO.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "user_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_dep")
    private String userDep;

    @Column(name = "user_grade")
    private int userGrade;

    @Column(name = "user_num")
    private int userNum;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_date")
    private Timestamp userDate;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_nick")
    private String userNick;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserNo(memberEntity.getUserNo());
        memberEntity.setUserEmail(memberEntity.getUserEmail());
        memberEntity.setUserPw(memberEntity.getUserPw());
        memberEntity.setUserGender(memberEntity.getUserGender());
        memberEntity.setUserDep(memberEntity.getUserDep());
        memberEntity.setUserGrade(memberEntity.getUserGrade());
        memberEntity.setUserNum(memberEntity.getUserNum());
        memberEntity.setUserType(memberEntity.getUserType());
        memberEntity.setUserDate(memberEntity.getUserDate());
        memberEntity.setUserName(memberEntity.getUserName());
        memberEntity.setUserNick(memberEntity.getUserNick());

        return memberEntity;
    }

    public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserNo(memberEntity.getUserNo());
        memberEntity.setUserEmail(memberEntity.getUserEmail());
        memberEntity.setUserPw(memberEntity.getUserPw());
        memberEntity.setUserGender(memberEntity.getUserGender());
        memberEntity.setUserDep(memberEntity.getUserDep());
        memberEntity.setUserGrade(memberEntity.getUserGrade());
        memberEntity.setUserNum(memberEntity.getUserNum());
        memberEntity.setUserType(memberEntity.getUserType());
        memberEntity.setUserDate(memberEntity.getUserDate());
        memberEntity.setUserName(memberEntity.getUserName());
        memberEntity.setUserNick(memberEntity.getUserNick());

        return memberEntity;
    }
}

