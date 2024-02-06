package com.damoim.member;

import com.damoim.constant.Role;
import com.damoim.entity.BaseEntity;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member_table")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "increment")
    @Column(name = "member_id")
    private Long id;

    @Column(name = "login_id", unique = true)
    private String loginId;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    public static Member toMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
        Member member =new Member();
        member.setLoginId(memberDto.getLoginId());
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        member.setRole(Role.USER);
        return member;
    }

}

