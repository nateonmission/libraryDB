package com.librarydb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class bookController {
    private static final Logger LOGGER = Logger.getLogger(bookController.class.getName());

    @GetMapping("/")
    public String isAlive(){
        LOGGER.info("calling getCategory method from controller");
        return "<h1>I'm Alive</h1>";
    }

}
