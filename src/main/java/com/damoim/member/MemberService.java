package com.damoim.member;

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
