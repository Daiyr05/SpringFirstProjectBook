package com.example.libraryprojectspring.book;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if(optionalBook.isPresent()){
            throw new IllegalStateException("Book is already added");
        }
        bookRepository.save(book);
    }

    public void removeBook(Long id) {
        boolean isExist = bookRepository.existsById(id);
        if(!isExist){
            throw new IllegalStateException("No such book in database");
        }
        bookRepository.deleteById(id);
    }
@Transactional
    public void updateBook(Long id, String description,Double rating) {
        Book book = bookRepository.findById(id).orElseThrow(()->new IllegalStateException("The book with such id: "+id+" doesn't exist"));
        if(description!= null && description.length()>0 && !Objects.equals(description,book.getDescription())){
            book.setDescription(description);
        }
    if(rating!= null && rating>=0 && !Objects.equals(rating,book.getRating())){
        book.setRating(rating);
    }
    }
}
