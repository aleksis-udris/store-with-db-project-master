package com.aleksis.backend.exceptions;

public enum ErrorMessages {
    ITEM_NOT_FOUND("The item could not be found."),
    ITEM_INT_NULL("The item values (price and count) cannot be null, 0 or negative."),
    ITEM_STRINGS_NULL("The item values (name and type) cannot be null or empty."),
    ITEM_EXP_DATE_NULL("The item expiration date cannot be null or before today's date."),;

    private final String s;

    public String getMessage() {
        return s;
    }

    ErrorMessages(String s) {
        this.s = s;
    }
}
