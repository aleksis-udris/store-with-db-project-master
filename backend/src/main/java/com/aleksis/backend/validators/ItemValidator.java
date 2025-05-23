package com.aleksis.backend.validators;

import com.aleksis.backend.exceptions.ErrorMessages;
import com.aleksis.backend.exceptions.ItemValueNotValidException;
import com.aleksis.backend.item.models.Item;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ItemValidator {
    private ItemValidator() {

    }

    public void execute(Item item) {
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

        if (item.getBar_code().chars().anyMatch(Character::isAlphabetic)) {
            throw new ItemValueNotValidException(ErrorMessages.ITEM_BARCODE_IS_INT.getMessage());
        }

        if (item.getBar_code().isEmpty()) {
            throw new ItemValueNotValidException(ErrorMessages.ITEM_BARCODE_IS_NULL.getMessage());
        }
    }
}
