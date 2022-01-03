package com.librarydb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "book_id")
    private List<Books> books;



    public genres() {
    }

    public genres(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
