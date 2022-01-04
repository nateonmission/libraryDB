package com.librarydb.repositories;

import com.librarydb.models.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors, Long> {
}
