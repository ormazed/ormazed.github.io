package com.example.simpleboard.post.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    // findById 사용 시 delete 후에도 /all 호출에 반응을 하기 때문에 별도 메서드를 추가

    // select * from post where id = ? and status = ? order by id desc limit 1;
    Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, String status);
}
