package com.ingress.bookstore.controller;

import com.ingress.bookstore.dto.request.RequestBook;
import com.ingress.bookstore.dto.response.Response;
import com.ingress.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final BookService bookService;

    @PostMapping("/newBook/{authorId}")
    public Response createNewBook(@PathVariable("authorId") Long authorId, @RequestBody RequestBook requestBook){
        return bookService.createNewBook(authorId,requestBook);
    }
}
