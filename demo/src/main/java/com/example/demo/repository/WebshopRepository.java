package com.example.demo.repository;

import com.example.demo.model.Webshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebshopRepository extends JpaRepository<Webshop, Long> {
    List<Webshop> findAll();
    List<Webshop> findByNameOrName(String name1, String name2);
    List<Webshop> findByPrice(int price);
    List<Webshop> findByPriceAndQuantity(int price, int quantity);
}
