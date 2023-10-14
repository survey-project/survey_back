package com.member.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/member")
public class MemberController {
    /**
     * 회원가입을 담당하는 메서드입니다.
     * @author 김민서
     * @since  1.0
     */
    // localhost:9100/api/v1/member/signup -> POST
    @PostMapping("/api/v1/member/signup")
    public void signup(){
    }

    /**
     * GET - 특정 정보를 조회
     * POST - 특정 요청을 저장
     * DELETE - 특정 정보를 지울때
     * PUT - 특정 정보를 업데이트 할때
     */
}
