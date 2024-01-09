package com.damoim.member;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class MemberDto {

    private int id;

    @NotBlank(message = "로그인 아이디를 입력해주세요.")
    private String loginId;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    private String nickname;


    private String email;


    private String password;
}
