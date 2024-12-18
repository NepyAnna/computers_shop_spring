package com.sheoanna.computers_shop_spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.sheoanna.computers_shop_spring.dtos.ComputerDto;
import com.sheoanna.computers_shop_spring.dtos.ShopDto;
import com.sheoanna.computers_shop_spring.models.Computer;
import com.sheoanna.computers_shop_spring.models.Shop;
import com.sheoanna.computers_shop_spring.repositories.ShopRepository;

public class ShopServiceTest {
    @Mock
    private ShopRepository shopRepository;

    @InjectMocks
    private ShopService shopService;

    private Shop shop;
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        computer.setComputer_id(1L);
        computer.setBrand("Dell");
        computer.setMemorySize("16GB");
        computer.setProcessorSpecification("Intel i7");
        computer.setOperatingSystem("Windows 10");
        computer.setPrice(1200.0);

        shop = new Shop();
        shop.setId_shop(1L);
        shop.setStoreName("Tech Store");
        shop.setTaxID(123456789);
        shop.setComputers(Collections.singletonList(computer));
    }

    @Test
    void testFindShopById() {

    }

    @Test
    void testIndex() {

    }
}
