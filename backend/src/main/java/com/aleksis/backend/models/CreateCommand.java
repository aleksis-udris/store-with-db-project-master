package com.aleksis.backend.models;

import com.aleksis.backend.item.models.Item;
import lombok.Data;

@Data
public class CreateCommand {
    private int id;
    private Item item;

    public CreateCommand(Integer id, Item inputItem) {
        this.id = id;
        this.item = inputItem;
    }
}
