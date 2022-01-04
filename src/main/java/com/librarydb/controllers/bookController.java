package com.librarydb.controllers;

import com.librarydb.models.Genres;
import com.librarydb.models.Publishers;
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

    // Update Genre
    // POST to http://localhost:9092/api/genres/genre_id
    @PutMapping(path = "/genres/{genreID}")
    public Genres updateGenre(@PathVariable(value = "genreID") Long genreID, @RequestBody Genres genreObject){
        LOGGER.info("calling updateGenre method from controller");
        return bookServices.updateGenre(genreID, genreObject);
    }

    // Delete Category
    // DELETE to http://localhost:9092/api/categories/cat_id
    @DeleteMapping(path = "/genres/{genreID}")
    public Genres deleteCategory(@PathVariable(value = "genreID") Long genreID){
        LOGGER.info("calling deleteCategory method from controller");
        return bookServices.deleteGenre(genreID);
    }

    // PUBLISHERS
    //  List All Publishers
    // http://localhost:9092/api/publishers
    @GetMapping("/publishers")
    public List<Publishers> getPublishers(){
        LOGGER.info("calling getPublishers method from controller");
        return bookServices.getPublishers();
    }

    // Create Publisher = POST	api/publishers
    // http://localhost:9092/api/publishers
    @PostMapping(path = "/publishers")
    public Publishers createPublisher(@RequestBody Publishers pubObject){
        LOGGER.info("calling createPublisher method from controller");
        return bookServices.createPublisher(pubObject);
    }

    // Update Publisher
    // POST to http://localhost:9092/api/publishers/pub_id
    @PutMapping(path = "/publishers/{pubID}")
    public Publishers updatePublisher(@PathVariable(value = "pubID") Long pubID, @RequestBody Publishers pubObject){
        LOGGER.info("calling updatePublisher method from controller");
        return bookServices.updatePublisher(pubID, pubObject);
    }

    // Delete Publisher
    // DELETE to http://localhost:9092/api/publishers/pub_id
    @DeleteMapping(path = "/publishers/{pubID}")
    public Publishers deletePublisher(@PathVariable(value = "pubID") Long pubID){
        LOGGER.info("calling deletePublisher method from controller");
        return bookServices.deletePublisher(pubID);
    }

}
