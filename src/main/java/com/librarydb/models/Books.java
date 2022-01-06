package com.librarydb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.librarydb.models.Genres;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

import java.util.Set;
import java.util.concurrent.Flow;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_title")
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

    @Column
    private boolean removedFromLibrary;

    @JsonIgnoreProperties("books")
    @ManyToMany(mappedBy = "books", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Authors> authors;

    @JsonIgnoreProperties("books")
    @ManyToMany(mappedBy = "books", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Publishers> publishers;

    @JsonIgnoreProperties("books")
    @ManyToMany(mappedBy = "books", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Genres> genres;

    public Books() {
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

    public Set<Genres> getGenres() {
        return genres;
    }

    public void setGenre(Set<Genres> genres) {
        this.genres = genres;
    }

    public void addGenre(Genres genre) {
        this.genres.add(genre);
        genre.getBooks().add(this);
    }

    public void removeGenre(Genres genre) {
        this.genres.remove(genre);
        genre.getBooks().remove(this);
    }



    public Set<Authors> getAuthors() {
        return authors;
    }

    public void setAuthor(Set<Authors> author) {
        this.authors = author;
    }

    public void addAuthor(Authors author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removeAuthor(Authors author) {
        this.authors.remove(author);
        author.getBooks().remove(this);
    }

    public Set<Publishers> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publishers> publishers) {
        this.publishers = publishers;
    }

    public void setRemovedFromLibrary(boolean removedFromLibrary) {
        this.removedFromLibrary = removedFromLibrary;
    }

    public boolean isRemovedFromLibrary() {
        return removedFromLibrary;
    }
}
