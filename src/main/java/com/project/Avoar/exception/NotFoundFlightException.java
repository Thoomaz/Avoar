package com.project.Avoar.exception;

public class NotFoundFlightException extends IllegalArgumentException {
    public NotFoundFlightException(String s) {
        super(s);
    }
}
