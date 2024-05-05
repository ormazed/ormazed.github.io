package com.example.jpa.user.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /* public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>
     에 선언된 내용만 가지고 개발을 바로 하면된다 */

}
