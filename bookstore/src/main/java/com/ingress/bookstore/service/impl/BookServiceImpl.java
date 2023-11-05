package com.ingress.bookstore.service.impl;

import com.ingress.bookstore.dto.request.RequestBook;
import com.ingress.bookstore.dto.response.Response;
import com.ingress.bookstore.dto.response.ResponseBook;
import com.ingress.bookstore.dto.response.ResponseStatus;
import com.ingress.bookstore.entity.Author;
import com.ingress.bookstore.entity.Book;
import com.ingress.bookstore.enums.EnumAvailableStatus;
import com.ingress.bookstore.respository.AuthorRepository;
import com.ingress.bookstore.respository.BookRepository;
import com.ingress.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    @Override
    public Response<List<ResponseBook>> getBookList() {
        Response<List<ResponseBook>> response=new Response<>();
        List<Book> bookList=bookRepository.findAllByActive(EnumAvailableStatus.ACTIVE.value);
        List<ResponseBook> responseBookList=bookList.stream().map(this::mapping).toList();
        response.setT(responseBookList);
        response.setResponseStatus(ResponseStatus.getSuccessMessage());
        return response;
    }

    @Override
    public Response createNewBook(Long authorId, RequestBook requestBook) {
        Response response=new Response();
        Author author=authorRepository.findAuthorByIdAndActive(authorId,EnumAvailableStatus.ACTIVE.value);
        Book book=Book.builder()
                .name(requestBook.getName())
                .author(author)
                .build();
        bookRepository.save(book);
        response.setResponseStatus(ResponseStatus.getSuccessMessage());
        return response;
    }


    public ResponseBook mapping(Book book){
        ResponseBook bookList=ResponseBook.builder().id(book.getId())
                .name(book.getName())
                .authorName(book.getAuthor().getName())
                .build();
        return bookList;
    }
}
