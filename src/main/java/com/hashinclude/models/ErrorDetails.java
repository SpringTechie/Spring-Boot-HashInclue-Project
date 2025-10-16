package com.hashinclude.models;

import lombok.Data;

@Data
public class ErrorDetails {
    private String errorMessage;
    private int errorCode;
}
