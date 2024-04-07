package com.example.demo.controller;

import com.example.demo.model.Webshop;
import com.example.demo.repository.WebshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebshopRestController {

    @Autowired
    //private WebshopService webshopService;
    private WebshopRepository webshopRepository;

    @GetMapping("/getAllItem")
    List<Webshop> getWebshopList(){
        return webshopRepository.findAll();
    }


    @GetMapping("/getItemByName")
    List<Webshop> getItemByName(@RequestParam String name1, String name2) {
        return webshopRepository.findByNameOrName(name1, name2);
    }

    @GetMapping("/getItemByPrice")
    List<Webshop> getItemByPrice(@RequestParam int price) {
        return webshopRepository.findByPrice(price);
    }

    @GetMapping("/getItemByPriceAndQuantity")
    List<Webshop> getItemByPriceAndQuantity(@RequestParam int price, int quantity) {
        return webshopRepository.findByPriceAndQuantity(price, quantity);
    }

}
