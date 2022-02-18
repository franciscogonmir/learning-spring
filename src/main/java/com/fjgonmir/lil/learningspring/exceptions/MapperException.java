package com.fjgonmir.lil.learningspring.exceptions;

public class MapperException extends Exception {

    private String message;

    public MapperException(String message){
        this.message = message;
    }
}
