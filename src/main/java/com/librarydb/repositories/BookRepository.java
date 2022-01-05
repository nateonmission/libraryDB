package com.librarydb.repositories;

import com.librarydb.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Books, Long> {
    Books findBookById(Long booksId);
    Books findByTitle(String booksTitle);
    Set<Books> findByAuthors(Long authorsId);
    Set<Books> findByPublisher(Long publishersId);
    Set<Books> findByGenres(Long genresId);
}
