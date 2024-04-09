package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "shopitems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_price")
    private int price;
    private int quantity;
    @Column(name = "date_added")
    private Date date;
}
