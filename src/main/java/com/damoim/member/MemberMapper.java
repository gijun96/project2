package com.damoim.member;

import com.damoim.entity.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("INSERT INTO member(login_id, name, nickname, email, password)"
        +" VALUES(#{member.loginId}, #{member.name}, #{member.nickname}, #{member.email}, #{member.password})")
    void insertMember(@Param("member")Member member);

}
