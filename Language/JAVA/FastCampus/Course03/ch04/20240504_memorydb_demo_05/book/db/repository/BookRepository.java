package com.example.demo.book.db.repository;

import com.example.demo.book.db.entity.BookEntity;
import com.example.demo.db.SimpleDataRepository;
import com.example.demo.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {
    public List<BookEntity> findAllCategory(String category){
        return this.findAll().stream()
                .filter(it -> {
                            return  it.getCategory().equals(category);
                        }
                ).collect(Collectors.toList());
    }

}
