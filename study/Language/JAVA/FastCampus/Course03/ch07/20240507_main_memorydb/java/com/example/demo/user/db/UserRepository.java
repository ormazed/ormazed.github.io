package com.example.demo.user.db;

import com.example.demo.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // 메서드로 처리하는 것이 아니라 SQL 문으로 조건을 filter 한다
    // findAllByScoreGreaterThanEqual() 라는 명명 자체가 => SELECT * FROM book_store.user WHERE score >= 90;

    public List<UserEntity> findAllByScoreGreaterThanEqual(int sc);

    // 방법1 : query 메서드 사용
    // findAllByScoreGreaterThanEqualAndScoreLessThanEqual 라는 명명 자체가  => select * from user where score >= ?? and score <= ??
    // Hibernate: select ue1_0.id,ue1_0.name,ue1_0.score from user ue1_0 where ue1_0.score>=? and ue1_0.score<=?
    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

}