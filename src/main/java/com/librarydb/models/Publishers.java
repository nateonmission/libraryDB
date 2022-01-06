package com.librarydb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "publishers")
public class Publishers {

    @Id
    @Column(name="publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="publisher_name")
    private String name;

    @JsonIgnoreProperties("publishers")
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "publisher_book", joinColumns = {@JoinColumn(name = "publisher_id")}, inverseJoinColumns =
    @JoinColumn(name = "book_id")
    )
    private Set<Books> books;

    @JsonIgnoreProperties("publishers")
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "author_publisher", joinColumns = {@JoinColumn(name = "publisher_id")}, inverseJoinColumns =
    @JoinColumn(name = "author_id")
    )
    private Set<Authors> authors;

    public Publishers() {
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
        books.getPublishers().add(this);
    }
}

