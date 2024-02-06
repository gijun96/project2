package com.damoim.controller;

import com.damoim.config.redis.RedisService;
import com.damoim.member.MemberService;
import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private RedisService redisService;
    @Value("${coolsms.api.key}")
    private String apiKey;
    @Value("${coolsms.api.APISecret}")
    private String APISecret;




// 아이디 중복 검사
    @GetMapping("/checkById")
    public ResponseEntity checkById(@RequestParam("userId") String userId){
        System.out.println("api 호출"+ userId);
        boolean existId = memberService.findId(userId);
        if (!existId){
        return ResponseEntity.status(400).build();
        }
    return ResponseEntity.status(200).build();
    }


    /**
     * 단일 메시지 발송 예제
     */
    @PostMapping("/send-one")
    public SingleMessageSentResponse sendOne(@RequestParam("phone") String setTO_Num) {
        System.out.println("setTO_Num :"+ setTO_Num);
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01036745733");
        message.setTo(setTO_Num);
        message.setText("한글 45자, 영자 90자 이하 입력되면 자동으로 SMS타입의 메시지가 추가됩니다.");

        DefaultMessageService messageService = NurigoApp.INSTANCE.initialize(apiKey, APISecret, "https://api.coolsms.co.kr");

        SingleMessageSentResponse response = messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);

        return response;
    }



}
