package com.librarydb.repositories;

import com.librarydb.models.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publishers, Long> {
    Publishers findByName(String publishersName);
}
