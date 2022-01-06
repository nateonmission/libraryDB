package com.librarydb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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

    @JsonIgnoreProperties("authors")
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "author_book", joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Books> books;


    @JsonIgnoreProperties("authors")
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "author_publisher", joinColumns = {@JoinColumn(name = "author_id")}, inverseJoinColumns =
    @JoinColumn(name = "publisher_id")
    )
    private Set<Publishers> publishers;



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

    public void setBooks(Books books) {
        this.getBooks().add(books);
        books.getAuthors().add(this);
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
