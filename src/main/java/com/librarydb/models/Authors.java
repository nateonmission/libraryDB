package com.librarydb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @Column(name="author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="author_name")
    private String name;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "authors")
    private Set<Books> books;

    @ManyToOne
    @JoinColumn(name="publishers")
    @JsonIgnore
    private Publishers publishers;

    public Authors() {
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
        book.getAuthors().add(this);
    }

    public void removeBook(Books book) {
        this.books.remove(book);
        book.getAuthors().remove(this);
    }
}
