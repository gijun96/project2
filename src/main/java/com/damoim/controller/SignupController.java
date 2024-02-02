package com.damoim.controller;

import com.damoim.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private MemberService memberService;

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
