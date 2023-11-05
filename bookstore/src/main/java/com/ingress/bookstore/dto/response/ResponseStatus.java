package com.ingress.bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatus {
    private Integer code;
    private String message;

    private final static Integer SUCCESS_CODE=1;
    private final static String SUCCESS_MESSAGE="success";
    public static ResponseStatus getSuccessMessage(){
        return new ResponseStatus(SUCCESS_CODE,SUCCESS_MESSAGE);
    }
}
