package com.example.demo.controller;

import com.example.demo.model.Webshop;
import com.example.demo.repository.WebshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    List<Webshop> getItemByName() {
        return webshopRepository.findByNameOrName("barack", "körte");
    }

    @GetMapping("/getItemByPrice")
    List<Webshop> getItemByPrice() {
        return webshopRepository.findByPrice(1200);
    }

    @GetMapping("/getItemByPriceAndQuantity")
    List<Webshop> getItemByPriceAndQuantity() {
        return webshopRepository.findByPriceAndQuantity(1200, 9);
    }

}
