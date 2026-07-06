package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository already gives us save/findAll/findById/delete etc, nothing else to add here
public interface BookRepository extends JpaRepository<Book, Long> {
}
