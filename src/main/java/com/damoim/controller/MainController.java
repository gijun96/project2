package com.damoim.controller;

import com.damoim.entity.Member;
import com.damoim.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberMapper memberMapper;

    @GetMapping("/")
    public String main(){
        return "main";
    }


}
