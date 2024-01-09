package com.damoim.entity;

import com.damoim.constant.Gender;
import com.damoim.constant.Role;
import lombok.Data;

@Data
public class Member {
    private int id;

    private String loginId;

    private String name;

    private String nickname;

    private String email;

    private String password;

    private Gender gender;

    private Role role;

}
