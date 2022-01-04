package com.librarydb.repositories;

import com.librarydb.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Long> {
    Books findById(String booksTitle);
    Books findByTitle(String booksTitle);
    List<Books> findByAuthorId(Long authorsId);
}
