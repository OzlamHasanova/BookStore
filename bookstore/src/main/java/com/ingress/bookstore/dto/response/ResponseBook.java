package com.ingress.bookstore.dto.response;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseBook {
    private Long id;
    private String name;
    private String authorName;


}
