package com.management.library.config;

import com.management.library.model.Book;
import com.management.library.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {

    private List<Book> books;

    @Bean
    List<Book> books() {
        return books;
    }

    @Bean
    public User getUser() {
        var user = new User();
        user.setUserId(1);
        user.setName("John Doe");
        user.setBorrowedBooks(new ArrayList<>());
        return user;
    }

    @PostConstruct
    void fillBooks() {
        var b1 = new Book();
        b1.setId(1);
        b1.setName("Book1");
        b1.setAuthor("Author1");
        b1.setGenre("Drama");
        b1.setPublicationYear(2023);
        b1.setPrice(20.50);
        b1.setCopies(4);

        var b2 = new Book();
        b2.setId(2);
        b2.setName("Book2");
        b2.setAuthor("Author2");
        b2.setGenre("Horror");
        b2.setPublicationYear(2020);
        b2.setPrice(15);
        b2.setCopies(2);

        var b3 = new Book();
        b3.setId(3);
        b3.setName("Book3");
        b3.setAuthor("Author3");
        b3.setGenre("Comedy");
        b3.setPublicationYear(2024);
        b3.setPrice(30);
        b3.setCopies(2);

        var b4 = new Book();
        b4.setId(4);
        b4.setName("Book4");
        b4.setAuthor("Author4");
        b4.setGenre("Sci-Fi");
        b4.setPublicationYear(2024);
        b4.setPrice(30);
        b4.setCopies(0);
        books = List.of(b1, b2, b3, b4);
    }
}
