package com.aleksis.backend.formatters;

import com.aleksis.backend.item.models.Item;
import org.springframework.stereotype.Service;

@Service
public class StringFormatter {
    public StringFormatter(){

    }

    public void execute(Item input) {
        String formattedType = input.getType();
        String formattedBarCode = input.getBar_code();
        String formattedName = input.getName();

        input.setType(formattedType.trim());
        input.setBar_code(formattedBarCode.trim());
        input.setName(formattedName.trim());
    }
}
