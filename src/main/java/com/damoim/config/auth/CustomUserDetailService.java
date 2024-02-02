//package com.damoim.config.auth;
//
//import com.damoim.entity.Member;
//import com.damoim.member.MemberRepository;
//import com.damoim.member.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.security.Principal;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
//        Member member = memberRepository.findByLoginId(loginId);
//        if(member == null){
//            throw new UsernameNotFoundException(loginId);
//        }
//        String password = passwordEncoder.encode(member.getPassword());
//        member.setPassword(password);
//
//        CustomUserDetails userDetails = new CustomUserDetails(member);
//        userDetails.setAuthenticated(true);
//
//        return userDetails;
//    }
//}
