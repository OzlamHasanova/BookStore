package com.ingress.bookstore.controller;

import com.ingress.bookstore.dto.response.Response;
import com.ingress.bookstore.dto.response.ResponseBook;
import com.ingress.bookstore.entity.Book;
import com.ingress.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final BookService bookService;

    @GetMapping("/books")
    public Response<List<ResponseBook>> getBookList(){
        return bookService.getBookList();
    }
}
