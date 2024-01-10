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

    public void login(MemberDto memberDto) throws Exception{
        String userId = memberDto.getLoginId();
        Member member = memberRepository.findByLoginId(userId);
        if (member == null){
            throw new IllegalArgumentException("유효하지 않은 아이디 입니다.");
        }
        

    }
}
