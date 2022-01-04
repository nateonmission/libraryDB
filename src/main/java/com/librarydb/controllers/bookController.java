package com.librarydb.controllers;

import com.librarydb.models.Genres;
import com.librarydb.repositories.AuthorRepository;
import com.librarydb.repositories.BookRepository;
import com.librarydb.repositories.GenreRepository;
import com.librarydb.repositories.PublisherRepository;
import com.librarydb.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class bookController {
    private static final Logger LOGGER = Logger.getLogger(bookController.class.getName());

    // JavaBeans POJO - One Instance for whole class
    private BookServices bookServices;
    @Autowired
    public void setBookService(BookServices bookServices){
        this.bookServices = bookServices;
    }

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

    @GetMapping("/")
    public String isAlive(){
        LOGGER.info("calling isAlive method from controller");
        return "<h1>I'm Alive</h1>";
    }

    //  List All Categories
    // http://localhost:9092/api/genres
    @GetMapping("/genres")
    public List<Genres> getGenres(){
        LOGGER.info("calling getGenres method from controller");
        return bookServices.getGenres();
    }

    // Create Genre = POST	api/genres
    // http://localhost:9092/api/genres
    @PostMapping(path = "/genres")
    public Genres createGenre(@RequestBody Genres genreObject){
        LOGGER.info("calling createGenre method from controller");
        return bookServices.createGenre(genreObject);
    }

}
