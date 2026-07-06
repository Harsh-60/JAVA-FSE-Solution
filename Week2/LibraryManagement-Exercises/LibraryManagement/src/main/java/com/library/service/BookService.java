package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    // no-arg constructor, needed so the XML setter-injection config still works
    public BookService() {
    }

    // constructor injection - exercise 7
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // setter injection - exercise 2 / 7
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        bookRepository.save(title);
    }

    public List<String> getAllBooks() {
        return bookRepository.findAll();
    }

    public void removeBook(String title) {
        boolean removed = bookRepository.delete(title);
        if (!removed) {
            System.out.println("Book not found: " + title);
        }
    }
}
