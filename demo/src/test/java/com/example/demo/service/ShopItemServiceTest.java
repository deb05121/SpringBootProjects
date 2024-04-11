package com.example.demo.service;

import com.example.demo.model.ShopItem;
import com.example.demo.repository.WebshopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShopItemServiceTest {
    @InjectMocks
    private WebshopService webshopService;

    @Mock
    private WebshopRepository webshopRepository;

    @Test
    void shouldFindByPrice() {
        //given
        final var name1 = "banana";
        final var priceOfItem = 10;
        final Date date = null;

        //when
        when(webshopRepository.findByPrice(priceOfItem)).thenReturn(
                List.of(ShopItem.builder()
                        .id(1)
                        .name(name1)
                        .price(priceOfItem)
                        .quantity(1)
                        .date(null)
                        .build()));
        final var shopItems = webshopService.findByPrice(priceOfItem);

        //then
        Assertions.assertEquals(1, shopItems.size());
        Assertions.assertEquals(name1, shopItems.get(0).getName());
        Assertions.assertEquals(priceOfItem, shopItems.get(0).getPrice());
    }

    @Test
    void shouldFindByPriceAndQuantity() {
        //given
        final var quantityOfItem = 5;
        final var priceOfItem = 10;
        final Date date = null;

        //when
        when(webshopRepository.findByPriceAndQuantity(priceOfItem, quantityOfItem)).thenReturn(
                List.of(ShopItem.builder()
                        .id(1)
                        .name("banana")
                        .price(priceOfItem)
                        .quantity(quantityOfItem)
                        .date(null)
                        .build()));
        final var shopItems = webshopService.findByPriceAndQuantity(priceOfItem, quantityOfItem);

        //then
        Assertions.assertEquals(1, shopItems.size());
        Assertions.assertEquals(quantityOfItem, shopItems.get(0).getQuantity());
        Assertions.assertEquals(priceOfItem, shopItems.get(0).getPrice());
    }

    @Test
    void shouldFindByNameOrName() {
        //given
        final var nameOfItemA = "banana";
        final var nameOfItemB = "cherry";
        final Date date = null;

        //when
        when(webshopRepository.findByNameOrName(nameOfItemB, nameOfItemA)).thenReturn(
                List.of(ShopItem.builder()
                                .id(1)
                                .name(nameOfItemA)
                                .price(1)
                                .quantity(1)
                                .date(null)
                                .build(),
                        ShopItem.builder()
                                .id(2)
                                .name(nameOfItemB)
                                .price(2)
                                .quantity(2)
                                .date(null)
                                .build())
        );
        final var shopItems = webshopService.findByTwoNames(nameOfItemB, nameOfItemA);

        //then
        Assertions.assertEquals(2, shopItems.size());
        Assertions.assertEquals(nameOfItemA, shopItems.get(0).getName());
        Assertions.assertEquals(nameOfItemB, shopItems.get(1).getName());
    }

}
