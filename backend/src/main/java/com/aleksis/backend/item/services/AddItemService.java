package com.aleksis.backend.item.services;

import com.aleksis.backend.models.Command;
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

    public AddItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public ResponseEntity<ItemDTO> execute(Item input) {
        input.setAdded_to_register(LocalDate.now() + " " + LocalTime.now());
        System.out.println(input.getAdded_to_register());

        ItemValidator.execute(input);

        Item item = itemRepo.save(input);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ItemDTO(item));
    }
}
