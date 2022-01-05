package com.librarydb.repositories;

import com.librarydb.models.Authors;
import com.librarydb.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Authors, Long> {
    Authors findByName(String authorsName);
    List<Authors> findByBooksId(Long booksId);
    List<Authors> findByPublishersId(Long publishersId);
}
