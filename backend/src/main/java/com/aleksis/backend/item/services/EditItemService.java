package com.aleksis.backend.item.services;

import com.aleksis.backend.item.models.*;
import com.aleksis.backend.models.Command;
import com.aleksis.backend.models.CreateCommand;
import com.aleksis.backend.validators.ItemValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EditItemService implements Command<CreateCommand, ItemDTO> {
    private final ItemRepo itemRepo;

    public EditItemService(ItemRepo itemRepo) {this.itemRepo = itemRepo;}

    @Override
    public ResponseEntity<ItemDTO> execute(CreateCommand input) {
        Item item = input.getItem();
        item.setId(input.getId());

        ItemValidator.execute(item);

        itemRepo.save(item);
        return ResponseEntity.ok(new ItemDTO(item));

    }
}
