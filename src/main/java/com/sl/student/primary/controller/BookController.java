package com.sl.student.primary.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sl.student.primary.model.Request;
import com.sl.student.secondary.dao.CommonDaoImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
public class BookController {

    private final CommonDaoImpl bookService;

    public BookController(CommonDaoImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/getBooks")
    public String getBook(@RequestBody Request request) throws JsonProcessingException {

        return  bookService.getProcData(request);
    }
}
