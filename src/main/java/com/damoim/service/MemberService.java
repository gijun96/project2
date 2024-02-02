package com.damoim.service;

import com.damoim.dto.MemberDto;
import com.damoim.entity.Member;
import com.damoim.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        Member member = Member.toMember(memberDto, passwordEncoder);
        memberRepository.save(member);
    }

    public Boolean findId(String userId){
        int existVal = memberRepository.existById(userId);
        // 존재하면 1 없으면 0 출력
        if (existVal == 1){
            System.out.println("이미 존재하는 아이디.");
            return false;
        }
        return true;
    }

}
