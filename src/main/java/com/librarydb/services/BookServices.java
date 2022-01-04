package com.librarydb.services;

import com.librarydb.controllers.bookController;
import com.librarydb.repositories.AuthorRepository;
import com.librarydb.repositories.BookRepository;
import com.librarydb.repositories.GenreRepository;
import com.librarydb.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class BookServices {
    private static final Logger LOGGER = Logger.getLogger(bookController.class.getName());

    // JavaBeans POJO - One Instance for whole class
    private BookRepository bookRepository;
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private AuthorRepository authorRepository;
    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    private GenreRepository genreRepository;
    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {

        this.genreRepository = genreRepository;
    }

    private PublisherRepository publisherRepository;
    @Autowired
    public void setPublisherRepository(PublisherRepository publisherRepository) {

        this.publisherRepository = publisherRepository;
    }


}
