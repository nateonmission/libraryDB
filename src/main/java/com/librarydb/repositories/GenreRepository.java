package com.librarydb.repositories;

import com.librarydb.models.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genres, Long> {
}
