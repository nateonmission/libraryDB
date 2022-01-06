package com.librarydb;

import com.librarydb.controllers.bookController;
import com.librarydb.models.Books;
import com.librarydb.repositories.BookRepository;
import com.librarydb.services.BookServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryDbApplicationTests {

//    @LocalServerPort
//    private int port;

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    private bookController controller;

    @MockBean
    private BookServices services;

    private BookRepository bookRepository;
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // BASIC CONNECTION TESTS
    @Test
    public void contextLoads(){
        assertThat(controller).isNotNull();
    }

    @Test
    public void testDBSave() {
        Books book = new Books();
        String title = "Testing the Test4";
        book.setTitle(title);
        book.setIsbn10("1234567890");
        book.setIsbn13("1234567890123");
        bookRepository.save(book);
        Books testBook = bookRepository.findByTitle(title);
        assertNotNull(bookRepository.findById(testBook.getId()).get());
        bookRepository.delete(book);
    }







}
