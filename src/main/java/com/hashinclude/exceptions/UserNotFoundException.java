package com.hashinclude.exceptions;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException {
    private String msg;
    private int statusCode;

    public UserNotFoundException(String msg,int statusCode) {
        super(msg);
        this.msg =  msg;
        this.statusCode = statusCode;
    }
}
