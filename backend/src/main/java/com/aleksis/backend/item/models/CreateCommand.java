package com.aleksis.backend.item.models;

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
