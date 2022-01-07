package com.librarydb.services;

import com.librarydb.controllers.bookController;
import com.librarydb.exceptions.InfoExistsException;
import com.librarydb.exceptions.InfoNotFoundException;
import com.librarydb.models.*;
import com.librarydb.repositories.AuthorRepository;
import com.librarydb.repositories.BookRepository;
import com.librarydb.repositories.GenreRepository;
import com.librarydb.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.logging.Logger;

@Service
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

    //BOOKS
    // GET all books api/books
    public List<Books> getBooks() {
        LOGGER.info("service calling getBooks ==>");
        List<Books> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new InfoNotFoundException("no books found");
        } else {
            LOGGER.info("Sorting book records");
            List<Books> newBooks = new ArrayList<>();
            for(Books book : books){
                if(!book.isRemovedFromLibrary()) {
                    try {
                        newBooks.add(book);
                        LOGGER.info("book added");
                    } catch (Exception e) {
                        throw new InfoNotFoundException( "Null!!!" );
                    }
                }
            }
            LOGGER.info("returning...");
            return newBooks;
        }
    }

    // GET a single book
    public Optional getBook(Long bookId) {
        LOGGER.info("service calling getBook ==>");
        Optional book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            return book;
        } else {
            throw new InfoNotFoundException("Book with id " + bookId + "not found");
        }
    }

    // TODO
    // GET an author's books
    public Set<Books> getAuthorBooks(Long authorsId) {
        LOGGER.info("service calling getAuthorBooks ==>");
        Set<Books> books = bookRepository.findByAuthorsId(authorsId);
        if(books.isEmpty()) {
            throw new InfoNotFoundException("Cannot retrieve books for an author with id "
                    + authorsId + "that does not exist");
        } else {
            return books;
        }
    }

    // TODO
    // GET a publisher's books
    public Set<Books> getPublisherBooks(Long publishersId) {
        LOGGER.info("service calling getPublisherBooks ==>");
        Set<Books> books = bookRepository.findBooksByPublishersId(publishersId);
        if(books.isEmpty()) {
            throw new InfoNotFoundException("Cannot retrieve books for publisher with id "
                    + publishersId + "that does not exist");
        } else {
            return books;
        }
    }

    // TODO
    // GET a genre's books
    public Set<Books> getGenreBooks(Long genresId) {
        LOGGER.info("service calling getGenreBooks ==>");
        Set<Books> books = bookRepository.findByGenresId(genresId);
        if(books.isEmpty()) {
            throw new InfoNotFoundException("Cannot retrieve books for genre with id "
                    + genresId + "that does not exist");
        } else {
            return books;
        }
    }

    // POST create a book api/books
    public Books createBook(Books bookObject) {
        LOGGER.info("service calling createBook ==>");
        Books book = bookRepository.findByTitle(bookObject.getTitle());
        if (book != null ) {
            if(book.isRemovedFromLibrary()){
                book.setRemovedFromLibrary(false);
                return bookRepository.save(book);
            } else {
                throw new InfoExistsException("book with name "
                        + book.getTitle() + " already exists");
            }
        } else {
            return bookRepository.save(bookObject);
        }
    }

    // PUT update a book api/books/{book_ID}
    public Books updateBook( Long bookID, Books bookObject) {
        LOGGER.info("service calling updateBook method ==> ");
        Optional<Books> book = bookRepository.findById(bookID);
        if (book == null) {
            throw new InfoNotFoundException("book with id " + bookID + " not found");
        } else {
            book.get().setTitle(bookObject.getTitle());
            book.get().setIsbn10(bookObject.getIsbn10());
            book.get().setIsbn13(bookObject.getIsbn13());
            book.get().setMediaType(bookObject.getMediaType());
            book.get().setRead(bookObject.isRead());
            book.get().setAvailable(bookObject.isAvailable());
            book.get().setRemovedFromLibrary(bookObject.isRemovedFromLibrary());
            return bookRepository.save(book.get());
        }
    }


    public Authors putBookAuthor(int authorID, HashMap<String, ArrayList<Integer>> books) {
        LOGGER.info("service calling updateBookAuthor method ==>");
        ArrayList<Integer> bookIds = books.get("books");
        Authors currentAuthor = authorRepository.findById((long) authorID).get();
        for (int bookId : bookIds) {
            if (!bookRepository.existsById((long) bookId))
                throw new InfoNotFoundException("Book not found");
            currentAuthor.setBooks(bookRepository.findById((long) bookId).get());
        }
        return authorRepository.save(currentAuthor);
    }

    public Genres putBookGenres(int genreID, HashMap<String, ArrayList<Integer>> books) {
        LOGGER.info("service calling updateBookGenre method ==>");
        ArrayList<Integer> bookIds = books.get("books");
        Genres currentGenre = genreRepository.findById((long) genreID).get();
        for (int bookId : bookIds) {
            if (!bookRepository.existsById((long) bookId))
                throw new InfoNotFoundException("Book not found");
            currentGenre.setBooks(bookRepository.findById((long) bookId).get());
        }
        return genreRepository.save(currentGenre);
    }

    public Publishers putBookPublishers(
            Long publisherID, HashMap<String, ArrayList<Long>> books) {
        LOGGER.info("service calling updateBookPublisher method ==>");
        ArrayList<Long> bookIds = books.get("books");
        Publishers currentPublisher = publisherRepository.findById( publisherID).get();
        for (long bookId : bookIds) {
            if (!bookRepository.existsById((long) bookId))
                throw new InfoNotFoundException("Book not found");
            currentPublisher.setBooks(bookRepository.findById( bookId).get());
        }
        return publisherRepository.save(currentPublisher);
    }

    // DELETE a book api/books/{bookID}
    public String deleteBook(Long bookID) {
        LOGGER.info("service calling deleteBook method ==>");
        Optional<Books> book = bookRepository.findById(bookID);
        if (book != null) {
            book.get().setRemovedFromLibrary(true);
            bookRepository.save(book.get());
            return (book.get().getTitle()) + " -- REMOVED = "
                    + book.get().isRemovedFromLibrary();
        } else {
            throw new InfoNotFoundException("book with id: "
                    + bookID + " does NOT exist");
        }
    }

    // AUTHORS
    // GET all authors api/authors
    public List<Authors> getAuthors() {
        LOGGER.info("service calling getAuthors ==>");
        List<Authors> authors = authorRepository.findAll();
        if (authors.isEmpty()) {
            throw new InfoNotFoundException("no authors found");
        } else {
            return authors;
        }
    }

    // POST create an author api/authors
    public Authors createAuthor(Authors authorObject) {
        LOGGER.info("service calling createAuthor ==>");
        Authors author = authorRepository.findByName(authorObject.getName());
        if (author != null) {
            throw new InfoExistsException("Author with name "
                    + author.getName() + " already exists");
        } else {
            return authorRepository.save(authorObject);
        }
    }

    // GET api/authors/{author_ID}
    public Optional getAuthor(Long authorId) {
        LOGGER.info("service calling getAuthor ==>");
        Optional author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            return author;
        } else {
            throw new InfoNotFoundException("Author with id "
                    + authorId + "not found");
        }
    }

    // GET a book's authors api/books/{book_ID}/authors
    public List<Authors> getBookAuthors(Long booksId) {
        LOGGER.info("service calling getBookAuthors ==>");
        List<Authors> authors = authorRepository.findByBooksId(booksId);
        if(authors.isEmpty()) {
            throw new InfoNotFoundException("Cannot retrieve authors for book with id "
                    + booksId + "that does not exist");
        } else {
            return authors;
        }
    }

    // GET a publisher's authors api/publishers/{publisher_ID}/authors
    public List<Authors> getPublisherAuthors(Long publishersId) {
        LOGGER.info("service calling getPublisherAuthors ==>");
        List<Authors> authors = authorRepository.findByPublishersId(publishersId);
        if(authors.isEmpty()) {
            throw new InfoNotFoundException("Cannot retrieve authors for a publisher with id "
                    + publishersId + "that does not exist");
        } else {
            return authors;
        }
    }

    // PUT update an author api/authors/{author_ID}
    public Authors updateAuthor(Long authorId, Authors authorObject) {
        LOGGER.info("service calling updateAuthor ==>");
        Optional<Authors> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
                Authors updateAuthor = authorRepository.findById(authorId).get();
                updateAuthor.setName(authorObject.getName());
                return authorRepository.save(updateAuthor);
        } else {
            throw new InfoNotFoundException("author with id "
                    + authorId + " not found");
        }
    }

    // DEL delete an author api/authors/{author_ID}
    public String deleteAuthor(Long authorId) {
        LOGGER.info("service calling updateAuthor ==>");
        Optional<Authors> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            authorRepository.deleteById(authorId);
            return author.get().getName();
        } else {
            throw new InfoNotFoundException("Author with id "
                    + authorId + " not found");
        }
    }

    // GET all genres api/genres
    public List<Genres> getGenres() {
        LOGGER.info("service calling getGenres ==>");
        List<Genres> genres = genreRepository.findAll();
        if (genres.isEmpty()) {
            throw new InfoNotFoundException("no categories found");
        } else {
            return genres;
        }
    }

    // POST create a genre api/genres
    public Genres createGenre(Genres genreObject) {
        LOGGER.info("service calling createGenre ==>");
        Genres genre = genreRepository.findByName(genreObject.getName());
        if (genre != null) {
            throw new InfoExistsException("category with name "
                    + genre.getName() + " already exists");
        } else {
            return genreRepository.save(genreObject);
        }
    }

    // GET a single genre api/genre/{genre_ID}
    public Optional getGenre(Long genreId) {
        LOGGER.info("service calling getGenre ==>");
        Optional genre = genreRepository.findById(genreId);
        if (genre.isPresent()) {
            return genre;
        } else {
            throw new InfoNotFoundException("Genre with id "
                    + genreId + "not found");
        }
    }

    // PUT update a genre api/genres/{genre_ID}
    public Genres updateGenre(Long genreID, Genres genreObject) {
        LOGGER.info("service calling updateGenre method ==> ");
        Optional<Genres> genre = genreRepository.findById(genreID);
        if (genre == null) {
            throw new InfoNotFoundException("category with id "
                    + genreID + " not found");
        } else {
            genre.get().setName(genreObject.getName());
            return genreRepository.save(genre.get());
        }
    }

    // DELETE a genre api/genres/{genreID}
    public String deleteGenre(Long genreID) {
        LOGGER.info("service calling deleteCategory method ==>");
        Optional<Genres> genre = genreRepository.findById(genreID);
        if (genre != null) {
            genreRepository.deleteById(genreID);
            return genre.get().getName();
        } else {
            throw new InfoNotFoundException("category with id: "
                    + genreID + " does NOT exists");
        }
    }

    // PUBLISHERS
    // GET all publishers api/publishers
    public List<Publishers> getPublishers() {
        LOGGER.info("service calling getPublishers ==>");
        List<Publishers> publishers = publisherRepository.findAll();
        if (publishers.isEmpty()) {
            throw new InfoNotFoundException("no publishers found");
        } else {
            return publishers;
        }
    }

    // POST create a publisher api/publishers
    public Publishers createPublisher(Publishers publisherObject) {
        LOGGER.info("service calling createPublisher ==>");
        Publishers pub = publisherRepository.findByName(publisherObject.getName());
        if (pub != null) {
            throw new InfoExistsException("publisher with name "
                    + pub.getName() + " already exists");
        } else {
            return publisherRepository.save(publisherObject);
        }
    }

    // GET a single publisher api/publisher/{publisher_ID}
    public Publishers getPublisher(Long publisherId) {
        LOGGER.info("service calling getPublisher ==>");
        Optional<Publishers> publisher = publisherRepository.findById(publisherId);
        if (publisher.isPresent()) {
            return publisher.get();
        } else {
            throw new InfoNotFoundException("Publisher with id "
                    + publisherId + "not found");
        }
    }

    // PUT update a publisher api/publishers/{pub_ID}
    public Publishers updatePublisher(Long pubID, Publishers publisherObject) {
        LOGGER.info("service calling updatePublisher method ==> ");
        Optional<Publishers> pub = publisherRepository.findById(pubID);
        if (pub == null) {
            throw new InfoNotFoundException("publisher with id "
                    + pubID + " not found");
        } else {
            pub.get().setName(publisherObject.getName());
            return publisherRepository.save(pub.get());
        }
    }

    // DELETE a publisher api/publishers/{pubID}
    public String deletePublisher(Long pubID) {
        LOGGER.info("service calling deletePublisher method ==>");
        Optional<Publishers> pub = publisherRepository.findById(pubID);
        if (pub != null) {
            publisherRepository.deleteById(pubID);
            return pub.get().getName();
        } else {
            throw new InfoNotFoundException("publisher with id: "
                    + pubID + " does NOT exist");
        }
    }

}
