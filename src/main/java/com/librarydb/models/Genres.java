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
    @ManyToMany (cascade = CascadeType.ALL, mappedBy = "publishers")
    @JoinColumn(name = "book_id")
    private List<Books> books;



    public Genres() {
    }

    public Genres(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
