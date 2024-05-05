package com.example.jpa.user.db;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class UserEntity {
    // MySQL 내 user.user 테이블과 UserEntitiy 변수들을 1:1 매핑하기 위함

    // DB 에서 id 는 primary key 로 동작하기 때문에 이를 인지시키기 위한 어노테이션이 필요하다
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
