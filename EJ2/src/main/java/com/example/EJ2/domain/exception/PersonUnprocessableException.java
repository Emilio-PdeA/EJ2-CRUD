package com.example.EJ2.domain.exception;

public class PersonUnprocessableException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PersonUnprocessableException(String message){super(message);}

}
