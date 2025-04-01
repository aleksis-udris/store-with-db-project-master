package com.aleksis.backend.item.services;

import com.aleksis.backend.item.models.Item;
import com.aleksis.backend.item.models.ItemDTO;
import com.aleksis.backend.item.models.ItemRepo;
import com.aleksis.backend.models.Query;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetItemsService implements Query<Void, List<ItemDTO>> {
    private final ItemRepo itemRepo;

    public GetItemsService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public ResponseEntity<List<ItemDTO>> execute(Void input) {
        List<Item> productList = itemRepo.findAll();
        List<ItemDTO> productDTOList = productList.stream().map(ItemDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }
}
