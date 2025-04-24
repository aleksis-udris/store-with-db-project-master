package com.aleksis.backend.item.services;

import com.aleksis.backend.formatters.StringFormatter;
import com.aleksis.backend.item.models.Command;
import com.aleksis.backend.item.models.Item;
import com.aleksis.backend.item.models.ItemDTO;
import com.aleksis.backend.item.models.ItemRepo;

import com.aleksis.backend.validators.ItemValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class AddItemService implements Command<Item, ItemDTO> {
    private final ItemRepo itemRepo;
    private final ItemValidator itemValidator;
    private final StringFormatter stringFormatter;

    public AddItemService(ItemRepo itemRepo, ItemValidator itemValidator, StringFormatter stringFormatter) {
        this.itemRepo = itemRepo;
        this.itemValidator = itemValidator;
        this.stringFormatter = stringFormatter;
    }

    @Override
    public ResponseEntity<ItemDTO> execute(Item input) {
        input.setAdded_to_register(LocalDate.now() + " " + LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute(), LocalTime.now().getSecond()));
        System.out.println(input.getAdded_to_register());

        stringFormatter.execute(input);
        itemValidator.execute(input);

        Item item = itemRepo.save(input);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ItemDTO(item));
    }
}
