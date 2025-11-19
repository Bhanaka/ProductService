package com.wings.product.exception;

public class DuplicateProductCodeException extends RuntimeException{
    public DuplicateProductCodeException(String message){
        super(message);
    }
}
