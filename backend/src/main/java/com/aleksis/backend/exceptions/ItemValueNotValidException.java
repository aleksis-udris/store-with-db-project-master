package com.aleksis.backend.exceptions;

public class ItemValueNotValidException extends RuntimeException {
    public ItemValueNotValidException(String message) {
        super(message);
    }
}
