package com.survey.member.Controller;

import com.survey.member.DTO.MemberDTO;
import com.survey.member.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    /**
     * 회원가입을 담당하는 메서드입니다.
     * @author 김민서
     * @since  1.0
     */
    // 생성자 주입
    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/signup")
    public ModelAndView saveForm() {
        return new ModelAndView("member/signup");
    }


    // 파라미터 String으로 받기 -> Service -> Repository -> DB저장
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDTO memberDTO){
        memberService.signup(memberDTO);
        return "login";
    }

    //로그인 화면
    @GetMapping("/login")
    public String saveFrom() {return "login";}
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult != null) {
            session.setAttribute("loginNum", loginResult.getUserNum());
            return "main";
        } else return "login";
    }
}
