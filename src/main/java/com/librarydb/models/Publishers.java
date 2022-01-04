package com.librarydb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.print.Book;
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

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "publisher")
    @JsonIgnore
    private List<Books> books;

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

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}

