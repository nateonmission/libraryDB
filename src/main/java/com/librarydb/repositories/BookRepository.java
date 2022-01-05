package com.librarydb.repositories;

import com.librarydb.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Books, Long> {
    Books findById(String booksTitle);
    Books findByTitle(String booksTitle);
    Set<Books> findByAuthorsId(Long authorsId);
    Set<Books> findBooksByPublishersId(Long publisherId);
    Set<Books> findByGenresId(Long genresId);
    
}
