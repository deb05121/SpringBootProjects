package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "shopitems")
@Getter
@Setter
public class Webshop {
    @Id
    private int id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_price")
    private int price;
    private int quantity;
    @Column(name = "date_added")
    private Date date;
}
