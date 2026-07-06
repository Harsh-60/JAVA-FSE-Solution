package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean(BookService.class);

        bookService.addBook("Clean Code");
        bookService.addBook("Effective Java");
        bookService.addBook("Spring in Action");

        System.out.println("Books currently in the library:");
        bookService.getAllBooks().forEach(System.out::println);

        bookService.removeBook("Effective Java");

        System.out.println("After removing a book:");
        bookService.getAllBooks().forEach(System.out::println);
    }
}
