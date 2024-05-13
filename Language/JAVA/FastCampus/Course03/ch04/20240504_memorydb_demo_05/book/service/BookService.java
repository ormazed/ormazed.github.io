package com.example.demo.book.service;

import com.example.demo.book.db.entity.BookEntity;
import com.example.demo.book.db.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository){

        this.bookRepository = bookRepository;
    }

    // Create, Update

    public BookEntity create(BookEntity book){

        return bookRepository.save(book);
    }

    // Read : All
    public List<BookEntity> findByAll(){
        return bookRepository.findAll();
    }
    // Read : One

    // Read : filterCategory
    public List<BookEntity> filterByCategory(String category){
        return bookRepository.findAllCategory(category);
    }
    // Delete
    public void delete(Long id){
        bookRepository.delete(id);
    }
}
