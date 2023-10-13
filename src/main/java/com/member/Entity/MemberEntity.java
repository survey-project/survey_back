package com.member.Entity;


import lombok.*;

import javax.persistence.*;

/**
 * Member Table과 매핑되는 클래스입니다.
 * @author : 김민서
 * @since : 1.0
 */
@Builder
@Getter
@Setter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String pwd;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "name")
    private String name;

    @Column(name = "Phone")
    private String phone;
}

