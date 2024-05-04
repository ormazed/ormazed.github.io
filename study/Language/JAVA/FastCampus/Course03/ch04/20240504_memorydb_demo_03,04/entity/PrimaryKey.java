package com.example.demo.entity;

public interface PrimaryKey { // 데이터베이스의 고유한 값

    void setId(Long id);
    Long getId();
}
