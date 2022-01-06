package com.librarydb.repositories;

import com.librarydb.models.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publishers, Long> {
    Publishers findByName(String publishersName);
    Optional<Publishers> findById(Long Id);
}
