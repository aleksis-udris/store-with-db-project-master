package com.aleksis.backend.item.services;

import com.aleksis.backend.formatters.StringFormatter;
import com.aleksis.backend.item.models.*;
import com.aleksis.backend.item.models.Command;
import com.aleksis.backend.item.models.CreateCommand;
import com.aleksis.backend.validators.ItemValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EditItemService implements Command<CreateCommand, ItemDTO> {
    private final ItemRepo itemRepo;
    private final ItemValidator itemValidator;

    public EditItemService(ItemRepo itemRepo, ItemValidator itemValidator) {
        this.itemRepo = itemRepo;
        this.itemValidator = itemValidator;
    }

    @Override
    public ResponseEntity<ItemDTO> execute(CreateCommand input) {
        Item item = input.getItem();
        item.setId(input.getId());

        itemValidator.execute(item);

        itemRepo.save(item);
        return ResponseEntity.ok(new ItemDTO(item));

    }
}
