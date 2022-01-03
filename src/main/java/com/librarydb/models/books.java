package com.librarydb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name ="books")
public class books {
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
    private Genre genre;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "author_id")
    private Author author;


    public books() {
    }

    public books(String title, Genre genre, Publisher publisher, Author author) {
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.author = author;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
