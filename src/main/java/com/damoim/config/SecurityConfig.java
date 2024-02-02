package com.damoim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.formLogin()
                .loginPage("/members/login")
                .usernameParameter("userId") // 로그인 페이지의 username으로 사용할 필드의 name과 맞춰줘야함
                .passwordParameter("userPassword")
                .loginProcessingUrl("/login")   // 해당 url이 호출되면 시큐리티가 낚아채서 대신 로그인 진행
                .defaultSuccessUrl("/")
                .failureUrl("/members/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        httpSecurity.authorizeRequests()
                .mvcMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .mvcMatchers("/", "/members/**","/api/**").permitAll()
                .mvcMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .anyRequest().authenticated()/* 그 외 모든 요청은 인증된 사용자만 접근이 가능하게 처리*/
        ;



        httpSecurity.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
        ;

        return httpSecurity.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // 사용자 비밀번호를 안전한 방식으로 (암호화) 하기 위한 BCryptPasswordEncoder(); 빈을 생성하고 반환
}
