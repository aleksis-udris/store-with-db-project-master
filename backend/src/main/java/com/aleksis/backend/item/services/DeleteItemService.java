package com.aleksis.backend.item.services;

import com.aleksis.backend.models.Command;
import com.aleksis.backend.item.models.Item;
import com.aleksis.backend.item.models.ItemRepo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteItemService implements Command<Integer, Void> {
    private final ItemRepo itemRepo;

    public DeleteItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        Optional<Item> item = itemRepo.findById(Long.valueOf(input));

        if (item.isPresent()) {
            itemRepo.deleteById(Long.valueOf(input));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new RuntimeException();
    }
}
