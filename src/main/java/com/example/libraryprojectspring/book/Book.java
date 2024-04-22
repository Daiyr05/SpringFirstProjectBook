package com.example.libraryprojectspring.book;

import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
        strategy =GenerationType.SEQUENCE,
        generator = "book_sequence"
    )
    private Long id;
    private String description;
    private Double rating;

    public Book() {

    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Book(String description, Double rating) {
        this.description = description;
        this.rating = rating;
    }

    public Book(Long id, String description, Double rating) {
        this.id = id;
        this.description = description;
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
