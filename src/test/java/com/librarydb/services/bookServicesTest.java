package com.librarydb.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class bookServicesTest {

    @LocalServerPort
    private int port;

    @Autowired
    private BookServices services;

    @Autowired
    private TestRestTemplate restTemplate;

    // Loads context
    @Test
    public void contextLoad() {
        assertThat(services).isNotNull();
    }

    // Tests live server
    @Test
    public void isAlive() {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/", String.class))
                .contains("<h1>I'm Alive</h1>");
    }

    // Basic Endpoint Tests
    @Test
    void getBooks() throws Exception {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/books", String.class)).contains("title");
    }

    @Test
    void getAuthors() {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/authors", String.class)).contains("name");
    }

    @Test
    void getGenres() {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/genres", String.class)).contains("name");
    }

    @Test
    void getPublishers() {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/publishers", String.class)).contains("name");
    }
}