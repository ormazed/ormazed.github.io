package com.example.demo.book.db.controller;


import com.example.demo.book.db.entity.BookEntity;
import com.example.demo.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

    private final BookService bookService;

    @PostMapping("")
    public BookEntity create(
        @RequestBody BookEntity bookEntity
    ){
        return bookService.create(bookEntity);
    }
    @GetMapping("/all")
    public List<BookEntity> findByAll(){
        return bookService.findByAll();
    }

    @GetMapping("/category")
    public List<BookEntity> filterByCategory(
            @RequestParam String category
    ){
        return bookService.filterByCategory(category);
    }

    @DeleteMapping("/id/{id}")
    public void delete(
            @PathVariable Long id
    ){
        bookService.delete(id);
    }

}
