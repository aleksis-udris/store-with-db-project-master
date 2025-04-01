package com.aleksis.backend.item.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private double price;

    @Column(name = "count")
    private int count;

    @Column(name = "added_to_register")
    private String added_to_register;

    @Column(name = "expiration")
    private String expiration;
}
