package com.librarydb.services;

import com.librarydb.controllers.bookController;
import com.librarydb.exceptions.InfoExistsException;
import com.librarydb.exceptions.InfoNotFoundException;
import com.librarydb.models.Authors;
import com.librarydb.models.Genres;
import com.librarydb.models.Publishers;
import com.librarydb.repositories.AuthorRepository;
import com.librarydb.repositories.BookRepository;
import com.librarydb.repositories.GenreRepository;
import com.librarydb.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    // GET api/authors
    public List<Authors> getAuthors() {
        LOGGER.info("service calling getAuthors ==>");
        return authorRepository.findAll();
    }

    // POST api/authors
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
            throw new InfoNotFoundException("Author with id " + authorId + "not found");
        }
    }

    // GET api/books/{book_ID}/authors
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

    // GET api/publishers/{publisher_ID}/authors
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


    // PUT api/authors/{author_ID}
    public Authors updateAuthor(Long authorId, Authors authorObject) {
        LOGGER.info("service calling updateAuthor ==>");
        Optional<Authors> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            if (authorObject.getName().equals(author.get().getName())) {
                throw new InfoExistsException("Author "
                        + author.get().getName() + " already exists");
            } else {
                Authors updateAuthor = authorRepository.findById(authorId).get();
                updateAuthor.setName(authorObject.getName());
                return authorRepository.save(updateAuthor);
            }
        } else {
            throw new InfoNotFoundException("author with id " + authorId + " not found");
        }
    }

    // DEL api/authors/{author_ID}
    public Optional<Authors> deleteAuthor(Long authorId) {
        LOGGER.info("service calling updateAuthor ==>");
        Optional<Authors> author = authorRepository.findById(authorId);
        if (author.isPresent()) {
            authorRepository.deleteById(authorId);
            return author;
        } else {
            throw new InfoNotFoundException("Author with id " + authorId + " not found");
        }
    }

    // GET api/genres
    public List<Genres> getGenres() {
        LOGGER.info("service calling getGenres ==>");

        List<Genres> genres = genreRepository.findAll();
        if (genres.isEmpty()) {
            throw new InfoNotFoundException("no categories found");
        } else {
            return genres;
        }
    }

    // POST api/genres
    public Genres createGenre(Genres genreObject) {
        LOGGER.info("service calling createGenre ==>");

        Genres genre = genreRepository.findByName(genreObject.getName());
        if (genre != null) {
            throw new InfoExistsException("category with name " + genre.getName() + " already exists");
        } else {
            return genreRepository.save(genreObject);
        }
    }

    // PUT api/genres/{genre_ID}
    public Genres updateGenre( Long genreID, Genres genreObject) {
        LOGGER.info("calling updateGenre method ==> ");

        Optional<Genres> genre = genreRepository.findById(genreID);
        if (genre == null) {
            throw new InfoNotFoundException("category with id " + genreID + " not found");
        } else {
            genre.get().setName(genreObject.getName());
            return genreRepository.save(genre.get());
        }
    }

    // DELETE api/genres/{genreID}
    public Genres deleteGenre( Long genreID) {
        LOGGER.info("calling deleteCategory method ==>");

        Optional<Genres> genre = genreRepository.findById(genreID);
        if (genre != null) {
            genreRepository.deleteById(genreID);
            return genre.get();
        } else {
            throw new InfoNotFoundException("category with id: " + genreID + " does NOT exists");
        }
    }

    // PUBLISHERS
    // GET api/genres
    public List<Publishers> getPublishers() {
        LOGGER.info("service calling getPublishers ==>");

        List<Publishers> publishers = publisherRepository.findAll();
        if (publishers.isEmpty()) {
            throw new InfoNotFoundException("no publishers found");
        } else {
            return publishers;
        }
    }

    // POST api/genres
    public Publishers createPublisher(Publishers publisherObject) {
        LOGGER.info("service calling createPublisher ==>");

        Publishers pub = publisherRepository.findByName(publisherObject.getName());
        if (pub != null) {
            throw new InfoExistsException("publisher with name " + pub.getName() + " already exists");
        } else {
            return publisherRepository.save(publisherObject);
        }
    }

    // PUT api/publishers/{pub_ID}
    public Publishers updatePublisher( Long pubID, Publishers publisherObject) {
        LOGGER.info("calling updatePublisher method ==> ");

        Optional<Publishers> pub = publisherRepository.findById(pubID);
        if (pub == null) {
            throw new InfoNotFoundException("publisher with id " + pubID + " not found");
        } else {
            pub.get().setName(publisherObject.getName());
            return publisherRepository.save(pub.get());
        }
    }

    // DELETE api/publishers/{pubID}
    public Publishers deletePublisher( Long pubID) {
        LOGGER.info("calling deletePublisher method ==>");

        Optional<Publishers> pub = publisherRepository.findById(pubID);
        if (pub != null) {
            publisherRepository.deleteById(pubID);
            return pub.get();
        } else {
            throw new InfoNotFoundException("publisher with id: " + pubID + " does NOT exists");
        }
    }


}
