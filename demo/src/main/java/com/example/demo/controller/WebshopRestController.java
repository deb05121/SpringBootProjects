package com.example.demo.controller;

import com.example.demo.model.ShopItem;
import com.example.demo.service.WebshopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class WebshopRestController {

    @Autowired

    private WebshopService webshopService;

    @GetMapping("/getAllItems")
    List<ShopItem> getWebshopList(){
        log.info("Finding items of Web shop.");
        return webshopService.findAllItems();
    }


    @GetMapping("/getItemsByName")
    List<ShopItem> getItemsByName(@RequestParam String name1, String name2) {
        log.info("Finding item by name {} and {}", name1, name2);
        return webshopService.findByTwoNames(name1, name2);
    }

    @GetMapping("/getItemsByPrice")
    List<ShopItem> getItemsByPrice(@RequestParam int price) {
        log.info("Finding item by price {}", price);
        return webshopService.findByPrice(price);
    }

    @GetMapping("/getItemsByPriceAndQuantity")
    List<ShopItem> getItemsByPriceAndQuantity(@RequestParam int price, int quantity) {
        log.info("Finding item by price {} and quantity {}", price, quantity);
        return webshopService.findByPriceAndQuantity(price, quantity);
    }

}
