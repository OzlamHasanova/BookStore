package com.ingress.bookstore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response<T> {
    @JsonProperty(value = "response")
    private T t;
    private ResponseStatus responseStatus;
}
