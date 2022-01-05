package com.librarydb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="genre_id")
    private Long id;

    @Column(name="genre_name")
    private String name;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "genres")
    private Set<Books> books;

    public Genres() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> book) {
        this.books = book;
    }

    public void addBook(Books book) {
        this.books.add(book);
        book.getGenres().add(this);
    }

    public void removeBook(Books book) {
        this.books.remove(book);
        book.getGenres().remove(this);
    }
}
