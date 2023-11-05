package com.ingress.bookstore.dto.response;

import com.ingress.bookstore.enums.UserRole;
import lombok.Data;

@Data
public class ResponseUser {
    private String username;
    private UserRole role;
    private ResponseToken responseToken;
}
