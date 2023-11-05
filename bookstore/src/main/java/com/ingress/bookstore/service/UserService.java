package com.ingress.bookstore.service;

import com.ingress.bookstore.dto.request.RequestToken;
import com.ingress.bookstore.dto.request.RequestUser;
import com.ingress.bookstore.dto.response.Response;
import com.ingress.bookstore.dto.response.ResponseUser;
import com.ingress.bookstore.entity.User;
import com.ingress.bookstore.enums.UserRole;

public interface UserService {
     Response<ResponseUser> saveUserWithRole(RequestUser requestUser);
     Response<ResponseUser> login(RequestUser requestUser);

     Response logout(RequestToken requestToken);
}
