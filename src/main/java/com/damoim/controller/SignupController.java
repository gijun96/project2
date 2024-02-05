package com.damoim.controller;

import com.damoim.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SignupController {

    private final MemberService memberService;

//    @Value("${coolsms.api.key}")
//    String apiKey;
//    @Value("${coolsms.api.APISecret}")
//    String APISecret;
//    @Autowired
//    final DefaultMessageService messageService;
//
//    public SignupController(){
//        this.messageService= NurigoApp.INSTANCE.initialize(apiKey, APISecret, "https://api.coolsms.co.kr");
//    }
//



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

//    /**
//     * 단일 메시지 발송 예제
//     */
//    @PostMapping("/send-one")
//    public SingleMessageSentResponse sendOne() {
//        Message message = new Message();
//        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
//        message.setFrom("01036745733");
//        message.setTo("01036745733");
//        message.setText("한글 45자, 영자 90자 이하 입력되면 자동으로 SMS타입의 메시지가 추가됩니다.");
//
//
//        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
//        System.out.println(response);
//
//        return response;
//    }



}
