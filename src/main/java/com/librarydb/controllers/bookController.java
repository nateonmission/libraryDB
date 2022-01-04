package com.librarydb.controllers;

import com.librarydb.models.Authors;
import com.librarydb.models.Genres;
import com.librarydb.repositories.AuthorRepository;
import com.librarydb.repositories.BookRepository;
import com.librarydb.repositories.GenreRepository;
import com.librarydb.repositories.PublisherRepository;
import com.librarydb.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    // GET all authors
    @GetMapping(path = "/authors")
    public List<Authors> getAuthors() {
        LOGGER.info("controller calling getAuthors ==>");
        return bookServices.getAuthors();
    }

    // POST create an author
    @PostMapping(path = "/authors")
    public Authors createAuthor (@RequestBody Authors authorObject) {
        LOGGER.info("controller calling createAuthor ==>");
        return bookServices.createAuthor(authorObject);
    }

    // GET a single author
    @GetMapping(path = "/authors/{author_ID}")
    public Optional getAuthor(@PathVariable Long authorId) {
        LOGGER.info("controller calling getAuthor ==>");
        return bookServices.getAuthor(authorId);
    }

    // GET a book's authors

    // GET a publisher's authors

    // PUT update an author
    @PutMapping(path = "/authors/{author_ID}")
    public Authors updateAuthor(@PathVariable(value="authorId") Long authorId,
                                @RequestBody Authors authorObject) {
        LOGGER.info("controller calling updateAuthor ==>");
        return bookServices.updateAuthor(authorId, authorObject);
    }

    // DEL delete an author
    @DeleteMapping(path = "/authors/{author_ID}")
    public Optional<Authors> deleteAuthor(@PathVariable(value="authorId") Long authorId) {
        return bookServices.deleteAuthor(authorId);
    }

    //  List All Genres
    // http://localhost:9092/api/genres
    @GetMapping("/genres")
    public List<Genres> getGenres(){
        LOGGER.info("calling getGenres method from controller");
        return bookServices.getGenres();
    }

    // Create a Genre = POST	api/genres
    // http://localhost:9092/api/genres
    @PostMapping(path = "/genres")
    public Genres createGenre(@RequestBody Genres genreObject){
        LOGGER.info("calling createGenre method from controller");
        return bookServices.createGenre(genreObject);
    }

    // Update a Genre
    // POST to http://localhost:9092/api/genres/genre_id
    @PutMapping(path = "/genres/{genreID}")
    public Genres updateGenre(@PathVariable(value = "genreID") Long genreID, @RequestBody Genres genreObject){
        LOGGER.info("calling updateGenre method from controller");
        return bookServices.updateGenre(genreID, genreObject);
    }

    // Delete a Genre
    // DELETE to http://localhost:9092/api/categories/genre_id
    @DeleteMapping(path = "/genres/{genreID}")
    public Genres deleteCategory(@PathVariable(value = "genreID") Long genreID){
        LOGGER.info("calling deleteCategory method from controller");
        return bookServices.deleteGenre(genreID);
    }

}
