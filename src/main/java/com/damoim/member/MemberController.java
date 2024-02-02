package com.damoim.member;

import com.damoim.dto.MemberDto;
import com.damoim.entity.Member;
import com.damoim.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("MemberDto", new MemberDto());
        return "member/loginForm";
    }
    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("loginFail", "로그인 정보를 다시 확인해 주시기 바랍니다.");
        return "member/loginForm";
    }


    @GetMapping("/join")
    public String memberForm(Model model){
        model.addAttribute("MemberDto", new MemberDto());
        return "member/memberForm";
    }

    @PostMapping("/new")
    public String signup(@Valid MemberDto memberDto, BindingResult result, Model model){
        System.out.println(memberDto.toString());
        try{
            memberService.saveMember(memberDto, passwordEncoder);
        }catch (Exception e){
            System.out.println(e.getMessage());
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberForm";
        }

        return "redirect:/";
    }
}
