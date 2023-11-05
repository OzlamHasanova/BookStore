package com.ingress.bookstore.dto.request;

import lombok.Data;

@Data
public class RequestToken {
    private Long userId;
    private String userToken;
}
