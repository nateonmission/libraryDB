package com.librarydb;

import com.librarydb.controllers.bookController;
import com.librarydb.services.BookServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LibraryDbApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private bookController controller;

    @MockBean
    private BookServices services;


    // BASIC CONNECTION TESTS
    @Test
    public void contextLoads(){
        assertThat(controller).isNotNull();
    }

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(services.isAlive()).thenReturn("<h1>I'm Alive</h1>");
    }

    // GET all from each model

    @Test
    public void getAllAuthors() throws Exception {
        when(services.getAuthors()).thenReturn();
    }






}
