package com.damoim.repository;


import com.damoim.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select * from member_table m where m.login_id = :userId", nativeQuery = true)
    Member findByLoginId(@Param("userId") String userId);
}
