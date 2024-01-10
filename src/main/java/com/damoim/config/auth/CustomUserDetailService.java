package com.damoim.config.auth;

import com.damoim.entity.Member;
import com.damoim.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Member member = memberRepository.findByLoginId(loginId);
        if(member == null){
            throw new UsernameNotFoundException(loginId);
        }
        String password = passwordEncoder.encode(member.getPassword());
        member.setPassword(password);

        CustomUserDetails userDetails = new CustomUserDetails(member);
        userDetails.setAuthenticated(true);
        return userDetails;
    }
}
