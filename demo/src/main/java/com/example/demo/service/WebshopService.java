package com.example.demo.service;

import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.ShopItem;
import com.example.demo.repository.WebshopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebshopService {

    private final WebshopRepository webshopRepository;

    public List<ShopItem> findByTwoNames(String name1, String name2) {
        final var items = webshopRepository.findByNameOrName(name1, name2);
        if (items.isEmpty()) {
            throw new ItemNotFoundException("No item is found with name " + name1 + " or name " + name2);
        }
        return items;
    }

    public List<ShopItem> findByPriceAndQuantity(int price, int quantity) {
        final var items = webshopRepository.findByPriceAndQuantity(price, quantity);
        if (items.isEmpty()) {
            throw new ItemNotFoundException("No item is found with price " + price + " and quantity " + quantity);
        }
        return items;
    }

    public List<ShopItem> findAllItems() {
        final var items = webshopRepository.findAll();
        if (items.isEmpty()) {
            throw new ItemNotFoundException("Webshop is empty.");
        }
        return items;
    }

    public List<ShopItem> findByPrice(int price) {
        final var items = webshopRepository.findByPrice(price);
        if (items.isEmpty()) {
            throw new ItemNotFoundException("No item is found with price " + price);
        }
        return items;
    }

    public ShopItem addItem(ShopItem shopItem) {
        return webshopRepository.save(shopItem);
    }

    public void deleteShopItem(long id) {
        webshopRepository.deleteById(id);
    }

    public void updateShopItem(long id, ShopItem shopItem) {
        final var itemToUpdate = webshopRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("No shop item found with id " + id));
        itemToUpdate.setName(shopItem.getName());
        itemToUpdate.setPrice(shopItem.getPrice());
        itemToUpdate.setQuantity(shopItem.getQuantity());
        itemToUpdate.setDate(shopItem.getDate());
        webshopRepository.save(itemToUpdate);
    }
}
