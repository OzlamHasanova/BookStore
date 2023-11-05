package com.ingress.bookstore.service;

import com.ingress.bookstore.dto.request.RequestBook;
import com.ingress.bookstore.dto.response.Response;
import com.ingress.bookstore.dto.response.ResponseBook;

import java.util.List;

public interface BookService {

    Response<List<ResponseBook>> getBookList();

    Response createNewBook(Long authorId, RequestBook requestBook);


}
