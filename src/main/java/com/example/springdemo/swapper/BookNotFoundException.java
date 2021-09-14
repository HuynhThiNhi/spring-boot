package com.example.springdemo.swapper;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(String message) {
        super(message);
    }

}
