package com.example.demo.repository;

import com.example.demo.model.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebshopRepository extends JpaRepository<ShopItem, Long> {
    List<ShopItem> findAll();
    List<ShopItem> findByNameOrName(String name1, String name2);
    List<ShopItem> findByPrice(int price);
    List<ShopItem> findByPriceAndQuantity(int price, int quantity);
}
