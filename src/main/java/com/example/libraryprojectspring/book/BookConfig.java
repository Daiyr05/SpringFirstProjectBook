package com.example.libraryprojectspring.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    public CommandLineRunner commandLineRunner (BookRepository bookRepository){
        return args -> {
            Book book1 = new Book("Rich father and Poor father",7.7);
            Book book2 = new Book("The richest person in Babylon",9.8);
          bookRepository.saveAll(List.of(book1,book2));
        };
    }
}
