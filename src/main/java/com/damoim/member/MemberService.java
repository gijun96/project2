package com.damoim.member;

import com.damoim.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void saveMember(Member member) {
        memberMapper.insertMember(member);
    }
}
