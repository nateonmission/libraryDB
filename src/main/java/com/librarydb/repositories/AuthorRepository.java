package com.librarydb.repositories;

import com.librarydb.models.Authors;
import com.librarydb.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Authors, Long> {
    Authors findByName(String authorsName);
    Authors findAuthorById(Long authorsId);
    Set<Authors> findByBooksId(Long booksId);
    Set<Authors> findByPublishersId(Long publishersId);
}
