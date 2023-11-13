package com.survey.member.Controller;

import com.survey.member.DTO.MemberDTO;
import com.survey.member.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.List;
import org.springframework.ui.Model;

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

    // 회원 목록 출력
    @GetMapping("/member/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        // 어떠한 html로 가져갈 데이터가 있다면 model 사용
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    //회원 정보 상세 조회
    @GetMapping("/member/{id}")
    public String findById(@PathVariable String id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member",memberDTO);
        return "detail";
    }

    //회원정보 수정
    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model) {
        String myEmail = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.updateForm(myEmail);
        model.addAttribute("updateMember",memberDTO);
        return "update";
    }

    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "redirect:/member/" + memberDTO.getUserNo();
    }

    //회원삭제
    @GetMapping("/member/delete/{id}")
    public String deleteById(@PathVariable String id) {
        memberService.deleteById(id);
        return "redirect:/member/";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
}

