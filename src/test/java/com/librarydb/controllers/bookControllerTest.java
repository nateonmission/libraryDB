package com.librarydb.controllers;

import com.librarydb.services.BookServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

public class bookControllerTest {

    @Autowired
    private BookServices services;

    @Test
    public void contextLoad() {
        assertThat(services).isNotNull();
    }

    @Test
    void setBookServices() {
    }

    @Test
    void isAlive() {
    }

    @Test
    void getBooks() {
    }

    @Test
    void getAuthors() {
    }

    @Test
    void getGenres() {
    }

    @Test
    void getPublishers() {
    }
}