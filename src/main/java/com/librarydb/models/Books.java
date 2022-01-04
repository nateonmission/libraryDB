package com.librarydb.models;

import com.librarydb.models.Genres;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.Flow;

@Entity
@Table(name ="books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String Isbn10;

    @Column
    private String Isbn13;

    @Column
    private String mediaType;

    @Column
    private boolean isRead;

    @Column
    private boolean isAvailable;

    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "genre_id")
    private Genres genres;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publishers publisher;

    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "author_id")
    private List<Authors> authors;


    public Books() {
    }

    public Books(String title, List<Genres> genres, Publishers publisher, List<Authors> authors) {
        this.title = title;
        this.genres = genres;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn10() {
        return Isbn10;
    }

    public void setIsbn10(String isbn10) {
        Isbn10 = isbn10;
    }

    public String getIsbn13() {
        return Isbn13;
    }

    public void setIsbn13(String isbn13) {
        Isbn13 = isbn13;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenre(List<Genres> genres) {
        this.genres = genres;
    }

    public Publishers getPublisher() {
        return publisher;
    }

    public void setPublisher(Publishers publisher) {
        this.publisher = publisher;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthor(List<Authors> authors) {
        this.authors = authors;
    }
}
