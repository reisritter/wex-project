package com.wex.app.controller.exception;

public class WexBusinessException extends RuntimeException{
    public WexBusinessException(String message) {
        super(message);
    }
}
