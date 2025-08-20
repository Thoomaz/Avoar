package com.project.Avoar.exception;

public class NotFoundUserException extends IllegalArgumentException{
    public NotFoundUserException(String s) {
        super(s);
    }
}
