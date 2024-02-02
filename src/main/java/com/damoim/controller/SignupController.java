package com.damoim.controller;

import com.damoim.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SignupController {

    private final MemberService memberService;

    @GetMapping("/checkById")
    public ResponseEntity checkById(@RequestParam("userId") String userId){
        System.out.println("api 호출"+ userId);
        boolean existId = memberService.findId(userId);
        System.out.println("existId :" + existId);
        if (!existId){
        return ResponseEntity.status(400).build();
        }
    return ResponseEntity.status(200).build();
    }

}
