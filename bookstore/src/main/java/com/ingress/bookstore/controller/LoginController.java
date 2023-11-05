package com.ingress.bookstore.controller;

import com.ingress.bookstore.dto.request.RequestToken;
import com.ingress.bookstore.dto.request.RequestUser;
import com.ingress.bookstore.dto.response.Response;
import com.ingress.bookstore.dto.response.ResponseUser;
import com.ingress.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @PostMapping("/login")
    public Response<ResponseUser> login(@RequestBody RequestUser requestUser){
        return userService.login(requestUser);
    }
    @PostMapping("/logout")
    public Response logout(@RequestBody RequestToken requestToken){
        return userService.logout(requestToken);
    }
}
