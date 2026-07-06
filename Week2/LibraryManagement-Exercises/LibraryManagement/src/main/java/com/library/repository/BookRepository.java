package com.library.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// pretending this talks to a DB, just keeping stuff in memory for now
@Repository
public class BookRepository {

    private final List<String> books = new ArrayList<>();

    public void save(String title) {
        books.add(title);
        System.out.println("Saved book: " + title);
    }

    public List<String> findAll() {
        return books;
    }

    public boolean delete(String title) {
        return books.remove(title);
    }
}
