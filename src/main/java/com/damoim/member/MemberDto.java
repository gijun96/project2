package com.damoim.member;

import com.damoim.constant.Gender;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class MemberDto {

    private Long id;

    private String loginId;

    private String name;

    private String email;

    private String password;
}
