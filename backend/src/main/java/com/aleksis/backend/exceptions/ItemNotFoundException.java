package com.aleksis.backend.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
        super(ErrorMessages.ITEM_NOT_FOUND.getMessage());
    }
}
