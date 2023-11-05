package com.ingress.bookstore.controller;

import com.ingress.bookstore.dto.request.RequestUser;
import com.ingress.bookstore.dto.response.Response;
import com.ingress.bookstore.dto.response.ResponseUser;
import com.ingress.bookstore.entity.User;
import com.ingress.bookstore.enums.UserRole;
import com.ingress.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("register/student")
    public Response<ResponseUser> registerAsStudent(@RequestBody RequestUser requestUser) {
        return userService.saveUserWithRole(requestUser);
    }
    @PostMapping("register/author")
    public Response<ResponseUser> registerAsAuthor(@RequestBody RequestUser requestUser) {
        return userService.saveUserWithRole(requestUser);
    }

}
