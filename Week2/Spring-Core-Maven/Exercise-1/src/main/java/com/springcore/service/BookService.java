package com.springcore.service;

import com.springcore.repository.BookRepository;

public class BookService {

    private BookRepository repository;

    public void setRepository(BookRepository repository) {

        this.repository = repository;

    }

    public void showBooks() {

        repository.displayBooks();

    }

}
