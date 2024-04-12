package com.example.demo.controller;

import com.example.demo.model.ShopItem;
import com.example.demo.service.WebshopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebshopRestController {

    private final WebshopService webshopService;

    @GetMapping("/getAllItems")
    List<ShopItem> getWebshopList(){
        log.info("Finding items of Web shop.");
        return webshopService.findAllItems();
    }


    @GetMapping("/getItemsByTwoNames")
    List<ShopItem> getItemsByTwoNames(@RequestParam String name1, String name2) {
        log.info("Finding items by name {} or other name {}", name1, name2);
        return webshopService.findByTwoNames(name1, name2);
    }

    @GetMapping("/getItemsByPrice")
    List<ShopItem> getItemsByPrice(@RequestParam int price) {
        log.info("Finding items by price {}", price);
        return webshopService.findByPrice(price);
    }

    @GetMapping("/getItemsByPriceAndQuantity")
    List<ShopItem> getItemsByPriceAndQuantity(@RequestParam int price, int quantity) {
        log.info("Finding items by price {} and quantity {}", price, quantity);
        return webshopService.findByPriceAndQuantity(price, quantity);
    }

    @PostMapping("/shopitem")
    ShopItem addShopItem(@RequestBody ShopItem shopItem){
        log.info("Adding shop item {}", shopItem);
        return webshopService.addItem(shopItem);
    }

    @DeleteMapping("/shopitem/{id}")
    void deleteShopItem(@PathVariable long id){
        log.info("Delete shop item with id {}", id);
        webshopService.deleteShopItem(id);
    }

    @PutMapping("/shopitem/{id}")
    void updateShopItem(@PathVariable long id, @RequestBody ShopItem shopItem){
        log.info("Updating shop item with id {}", id);
        webshopService.updateShopItem(id, shopItem);
    }
}
