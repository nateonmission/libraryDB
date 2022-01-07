package com.librarydb.controllers;

import com.librarydb.models.Authors;
import com.librarydb.models.Books;
import com.librarydb.models.Genres;
import com.librarydb.models.Publishers;

import com.librarydb.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class bookController {
    private static final Logger LOGGER = Logger.getLogger(bookController.class.getName());

    private BookServices bookServices;
    @Autowired
    public void setBookServices(BookServices bookServices) {

        this.bookServices = bookServices;
    }

    @GetMapping("/")
    public String isAlive(){
        LOGGER.info("calling isAlive method from controller");
        return "<h1>I'm Alive</h1>";
    }

    // BOOKS
    // GET All Books
    @GetMapping("/books")
    public List<Books> getBooks() {
        LOGGER.info("calling getBooks method from controller");
        return bookServices.getBooks();
    }

    // GET a single Book
    @GetMapping(path = "/books/{bookId}")
    public Optional getBook(@PathVariable Long bookId) {
        LOGGER.info("controller calling getBook ==>");
        return bookServices.getBook(bookId);
    }

    // GET an author's books
    @GetMapping(path = "/authors/{authorsId}/books")
    public Set<Books> getAuthorBooks(@PathVariable Long authorsId) {
        LOGGER.info("controller calling getAuthorBooks ==>");
        return bookServices.getAuthorBooks(authorsId);
    }

    // GET a publisher's books
    @GetMapping(path = "/publishers/{publishersId}/books")
    public Set<Books> getPublisherBooks(@PathVariable Long publishersId) {
        LOGGER.info("controller calling getPublisherBooks ==>");
        return bookServices.getPublisherBooks(publishersId);
    }

    // GET a genre's books
    @GetMapping(path = "/genres/{genresId}/books")
    public Set<Books> getGenreBooks(@PathVariable Long genresId) {
        LOGGER.info("controller calling getGenreBooks ==>");
        return bookServices.getGenreBooks(genresId);
    }

    // POST Create a Book
    @PostMapping(path = "/books")
    public Books createBook(@RequestBody Books bookObject) {
        LOGGER.info("calling createBook method from controller");
        return bookServices.createBook(bookObject);
    }

    // PUT Update a Book
    @PutMapping(path = "/books/{book_ID}")
    public Books updateBook(
            @PathVariable(value = "book_ID") Long bookId,
            @RequestBody Books bookObject) {
        LOGGER.info("calling updateBook method from controller");
        return bookServices.updateBook(bookId, bookObject);
    }

    // PUT Update author's books (add bookIds to author)  "/authors/books/{authorID}"
    @PutMapping(path = "/authors/books/{authorID}")
    public Authors putBookAuthor(
            @PathVariable(value = "authorID") Long authorID,
            @RequestBody HashMap<String, ArrayList<Long>> books) {
        LOGGER.info("calling updateBookAuthor method from controller");
        return bookServices.putBookAuthor(authorID, books);
    }

    // PUT Update a genre's books (add bookIds to genre)
    @PutMapping(path = "/genres/books/{genreID}")
    public Genres putBookGenres(
            @PathVariable(value = "genreID") Long genreID,
            @RequestBody HashMap<String, ArrayList<Long>> books) {
        LOGGER.info("calling updateBookGenre method from controller");
        return bookServices.putBookGenres(genreID, books);
    }

    // PUT Update publisher's books (add bookIds to publisher)
    @PutMapping(path = "/publishers/books/{publisherID}")
    public Publishers putBookPublishers(
            @PathVariable(value = "publisherID") Long publisherID,
            @RequestBody HashMap<String, ArrayList<Long>> books) {
        LOGGER.info("calling updateBookPublishers method from controller");
        return bookServices.putBookPublishers(publisherID, books);
    }

    // DELETE a Book
    @DeleteMapping(path = "/books/{bookId}")
    public String deleteBook(@PathVariable(value = "bookId") Long bookID){
        LOGGER.info("calling deleteBook method from controller");
        return bookServices.deleteBook(bookID);
    }

    // GET all Authors
    @GetMapping(path = "/authors")
    public List<Authors> getAuthors() {
        LOGGER.info("controller calling getAuthors ==>");
        return bookServices.getAuthors();
    }

    // POST create an Author
    @PostMapping(path = "/authors")
    public Authors createAuthor(@RequestBody Authors authorObject) {
        LOGGER.info("controller calling createAuthor ==>");
        return bookServices.createAuthor(authorObject);
    }

    // GET a single Author
    @GetMapping(path = "/authors/{authorId}")
    public Optional getAuthor(@PathVariable Long authorId) {
        LOGGER.info("controller calling getAuthor ==>");
        return bookServices.getAuthor(authorId);
    }

    // GET a book's Authors
    @GetMapping(path = "/books/{booksId}/authors")
    public List<Authors> getBookAuthors(@PathVariable Long booksId) {
        LOGGER.info("controller calling getBookAuthors ==>");
        return bookServices.getBookAuthors(booksId);
    }

    // GET a publisher's Authors
    @GetMapping(path = "/publishers/{publishersId}/authors")
    public List<Authors> getPublisherAuthors(@PathVariable Long publishersId) {
        LOGGER.info("controller calling getPublisherAuthors ==>");
        return bookServices.getPublisherAuthors(publishersId);
    }

    // PUT update an Author
    @PutMapping(path = "/authors/{authorId}")
    public Authors updateAuthor(@PathVariable(value = "authorId") Long authorId,
                                @RequestBody Authors authorObject) {
        LOGGER.info("controller calling updateAuthor ==>");
        return bookServices.updateAuthor(authorId, authorObject);
    }

    // PUT Update publisher's authors (add authorIds to publisher)
    @PutMapping(path = "/publishers/authors/{publishersID}")
    public Publishers putAuthorPublishers(
            @PathVariable(value = "publishersID") Long publishersID,
            @RequestBody HashMap<String, ArrayList<Long>> authors) {
        LOGGER.info("calling updateAuthorPublishers method from controller");
        return bookServices.putAuthorPublishers(publishersID, authors);
    }

    // PUT Update author's publisher (add publisherIds to author)
    @PutMapping(path = "/authors/publishers/{authorsID}")
    public Authors putPublisherAuthor(
            @PathVariable(value = "authorsID") Long authorsID,
            @RequestBody HashMap<String, ArrayList<Long>> publishers) {
        LOGGER.info("calling updatePublisherAuthor method from controller");
        return bookServices.putPublisherAuthor(authorsID, publishers);
    }

    // DEL delete an Author
    @DeleteMapping(path = "/authors/{authorId}")
    public String deleteAuthor(@PathVariable(value = "authorId") Long authorId) {
        LOGGER.info("controller calling deleteAuthor ==>");
        return bookServices.deleteAuthor(authorId);
    }

    // GET All Genres
    @GetMapping("/genres")
    public List<Genres> getGenres() {
        LOGGER.info("calling getGenres method from controller");
        return bookServices.getGenres();
    }

    // POST Create a single Genre
    @PostMapping(path = "/genres")
    public Genres createGenre(@RequestBody Genres genreObject) {
        LOGGER.info("calling createGenre method from controller");
        return bookServices.createGenre(genreObject);
    }

    // GET a single Genre
    @GetMapping(path = "/genres/{genre_ID}")
    public Optional getGenre(@PathVariable(value = "genre_ID") Long genreId) {
        LOGGER.info("controller calling getGenre ==>");
        return bookServices.getGenre(genreId);
    }

    // PUT Update a Genre
    @PutMapping(path = "/genres/{genreID}")
    public Genres updateGenre(
            @PathVariable(value = "genreID") Long genreID,
            @RequestBody Genres genreObject) {
        LOGGER.info("calling updateGenre method from controller");
        return bookServices.updateGenre(genreID, genreObject);
    }

    // DEL delete a Genre
    @DeleteMapping(path = "/genres/{genreID}")
    public String deleteGenre(@PathVariable(value = "genreID") Long genreID) {
        LOGGER.info("calling deleteGenre method from controller");
        return bookServices.deleteGenre(genreID);
    }

    // PUBLISHERS
    // GET List All Publishers
    @GetMapping("/publishers")
    public List<Publishers> getPublishers() {
        LOGGER.info("calling getPublishers method from controller");
        return bookServices.getPublishers();
    }

    // POST Create Publisher
    @PostMapping(path = "/publishers")
    public Publishers createPublisher(@RequestBody Publishers pubObject) {
        LOGGER.info("calling createPublisher method from controller");
        return bookServices.createPublisher(pubObject);
    }

    // GET a single Publisher
    @GetMapping(path = "/publishers/{publisher_ID}")
    public Publishers getPublisher(
            @PathVariable(value = "publisher_ID") Long publisherId) {
        LOGGER.info("controller calling getPublisher ==>");
        return bookServices.getPublisher(publisherId);
    }

    // PUT Update Publisher
    @PutMapping(path = "/publishers/{pubID}")
    public Publishers updatePublisher(
            @PathVariable(value = "pubID") Long pubID,
            @RequestBody Publishers pubObject) {
        LOGGER.info("calling updatePublisher method from controller");
        return bookServices.updatePublisher(pubID, pubObject);
    }

    // DEL delete Publisher
    @DeleteMapping(path = "/publishers/{pubID}")
    public String deletePublisher(@PathVariable(value = "pubID") Long pubID) {
        LOGGER.info("calling deletePublisher method from controller");
        return bookServices.deletePublisher(pubID);
    }

    // GET books by MediaType
    @GetMapping("/books/media/{MediaType}")
    public List<Books> getBooksByMediaType(@PathVariable(value = "MediaType") String MediaType) {
        LOGGER.info("calling getBooksByMediaType method from controller");
        return bookServices.getBooksByMediaType(MediaType);
    }

    // GET books by Availability
    @GetMapping("/books/available/{available}")
    public List<Books> getBooksByAvailability(@PathVariable(value = "available") boolean available) {
        LOGGER.info("calling getBooksByAvailability method from controller");
        return bookServices.getBooksByAvailability(available);
    }

    // GET books by isRead
    @GetMapping("/books/read/{read}")
    public List<Books> getBooksByIsRead(@PathVariable(value = "read") boolean read) {
        LOGGER.info("calling getBooksByIsRead method from controller");
        return bookServices.getBooksByIsRead(read);
    }

}
