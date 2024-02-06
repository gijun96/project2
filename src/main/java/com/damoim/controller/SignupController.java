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

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public ResponseEntity sendOne(@RequestParam("phone") String setTO_Num) {
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01036745733");
        message.setTo(setTO_Num);
        String Authentication_Num = random();

        // redis에 인증자 번호, 인증번호를 60초 동안 저장한다.
        redisService.setValues(setTO_Num, Authentication_Num, Duration.ofMillis(60000));
        message.setText("인증번호 6자리를 입력해주세요."+Authentication_Num);
        DefaultMessageService messageService = NurigoApp.INSTANCE.initialize(apiKey, APISecret, "https://api.coolsms.co.kr");
        SingleMessageSentResponse response = messageService.sendOne(new SingleMessageSendingRequest(message));
        String status = response.getStatusCode();
        System.out.println("statusCode"+ status);
        if (!(status.equals("2000"))){
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.status(200).build();
    }

    // 무작위 6자리 숫자 출력 메서드
    public String random(){
        Random random = new Random();
        List<String> numbers = new ArrayList<>();
        while(true){
            String ranNum = String.valueOf(random.nextInt(9));
            numbers.add(ranNum);
            if (numbers.size() == 6){
                System.out.println("numbers : " + numbers);
                break;
            }
        }
        return numbers.toString().replaceAll(", ", "");
    }


    @PostMapping("/validation")
    public ResponseEntity validation(@RequestParam("phone") String phone,
                                     @RequestParam("authentication_num") String authentication_num){
        String savedNum = redisService.getValues(phone).replaceAll("[^0-9]", "");
        System.out.println("phone : "+ phone+ ", authentication_num : "+ authentication_num);
        System.out.println("savedNum :"+ savedNum);
        if (!savedNum.equals(authentication_num)){
            System.out.println("인증번호가 일치하지않습니다.");
            return ResponseEntity.status(400).build();
        }
        redisService.deleteValues(phone);
        return ResponseEntity.status(200).build();
    }

}
