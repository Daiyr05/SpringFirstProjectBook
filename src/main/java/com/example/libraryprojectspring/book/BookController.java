package com.example.libraryprojectspring.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/book")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return  bookService.getBooks();
    }

    @PostMapping
    public void addNewBook(@RequestBody  Book book){
        bookService.addBook(book);
    }

    @DeleteMapping(path = {"{id}"})
    public void removeBook(@PathVariable("id")Long id){
        bookService.removeBook(id);
    }

    @PostMapping(path = "{id}")
    public void updateBook(@PathVariable Long id,
                           @RequestParam(required = true) String description,
                           @RequestParam(required = false) Double rating){
        bookService.updateBook(id, description, rating);

    }

}
