package com.aleksis.backend.item.services;

import com.aleksis.backend.item.models.ItemDTO;
import com.aleksis.backend.item.models.Item;
import com.aleksis.backend.item.models.ItemRepo;
import com.aleksis.backend.models.Query;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetItemService implements Query<Integer, ItemDTO> {
    private final ItemRepo itemRepo;

    public GetItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public ResponseEntity<ItemDTO> execute(Integer input) {
        Optional<Item> item = itemRepo.findById(Long.valueOf(input));

        if (item.isPresent()) {
            return ResponseEntity.ok(new ItemDTO(item.get()));
        }

        throw new RuntimeException();
    }
}
