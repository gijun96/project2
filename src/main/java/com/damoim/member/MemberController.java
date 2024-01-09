package com.damoim.member;

import com.damoim.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("LoginForm", new MemberDto());
        return "member/login";
    }

    @PostMapping("/login")
    public String login(Principal principal, Model model){
        System.out.println("principal.getName() :"+principal.getName());
        model.addAttribute("userId", principal.getName());
        return "main";
    }

    @GetMapping("/signup")
    public String memberForm(Model model){
        model.addAttribute("Member", new Member());
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid Member member, BindingResult result, Model model){
        if (result.hasErrors()){
            for (ObjectError error : result.getAllErrors()){
                System.err.println(error.getDefaultMessage());
            }
            return "member/signup";
        }
        try{

            memberService.saveMember(member);
        }catch (Exception e){
            model.addAttribute("errorMessage", e.getMessage());
            return "member/signup";
        }

        return "main";
    }
}
