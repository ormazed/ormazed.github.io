package com.example.demo.book.db.repository;

import com.example.demo.book.db.entity.BookEntity;
import com.example.demo.db.SimpleDataRepository;
import com.example.demo.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
