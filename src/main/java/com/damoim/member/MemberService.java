package com.damoim.member;

import com.damoim.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        Member member = memberRepository.findByLoginId(loginId);

        return   User.builder()
                .username(member.getLoginId())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }

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
