package com.aleksis.backend.validators;

import com.aleksis.backend.exceptions.ErrorMessages;
import com.aleksis.backend.exceptions.ItemValueNotValidException;
import com.aleksis.backend.item.models.Item;

import java.time.LocalDate;

public class ItemValidator {
    private ItemValidator() {

    }

    public static void execute(Item item) {
        LocalDate expDate = LocalDate.parse(item.getExpiration());

        if (item.getName() == null || item.getName().isEmpty()
                || item.getType() == null || item.getType().isEmpty()) {
            throw new ItemValueNotValidException(ErrorMessages.ITEM_STRINGS_NULL.getMessage());
        }

        if (item.getCount() == 0 || item.getCount() < 0 || item.getPrice() == 0 || item.getPrice() < 0) {
            throw new ItemValueNotValidException(ErrorMessages.ITEM_INT_NULL.getMessage());
        }

        if (expDate.isBefore(LocalDate.now()) || expDate.isEqual(LocalDate.now())) {
            throw new ItemValueNotValidException(ErrorMessages.ITEM_EXP_DATE_NULL.getMessage());
        }
    }
}
