//package com.damoim.config.auth;
//
//import com.damoim.entity.Member;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Map;
//
//@Getter
//@Setter
//@ToString
//public class CustomUserDetails implements UserDetails {
//
//    private Member member;
//    private String loginId;
//    private String password;
//    private String email;
//    private String name;
//    private Collection<? extends GrantedAuthority> authorities;
//    private boolean authenticated;
//    private Map<String, Object> attributes;
//    public CustomUserDetails(Member member){
//        this.member = member;
//        this.loginId = member.getLoginId();
//        this.password = member.getPassword();
//        this.email = member.getEmail();
//        this.name = member.getName();
//        this.authorities = Collections.singleton(new SimpleGrantedAuthority(member.getRole().toString()));
//        this.authenticated = true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> collect = new ArrayList<>();
//        collect.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//
//                return member.getRole().toString() ;
//            }
//        });
//        return collect;
//    }
//
//    @Override
//    public String getPassword() {
//        return member.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return member.getLoginId();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
