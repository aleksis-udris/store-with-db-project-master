package com.aleksis.backend.item.models;

import lombok.Data;

@Data
public class ItemDTO {
    private Integer id;
    private String name;
    private String type;
    private double price;
    private Integer count;
    private String added_to_register;
    private String expiration;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.type = item.getType();
        this.price = item.getPrice();
        this.count = item.getCount();
        this.added_to_register = item.getAdded_to_register();
        this.expiration = item.getExpiration();
    }
}
