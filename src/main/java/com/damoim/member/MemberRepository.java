package com.damoim.member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select * from member_table m where m.login_id = :userId", nativeQuery = true)
    Member findByLoginId(@Param("userId") String userId);

    @Query(value = "select EXISTS (select * from member_table where login_id= :userId limit 1) as success"
            , nativeQuery = true)
    int existById(@Param("userId") String userId);
}
