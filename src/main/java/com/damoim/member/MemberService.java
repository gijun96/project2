package com.damoim.member;

import com.damoim.dto.MemberDto;
import com.damoim.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
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
