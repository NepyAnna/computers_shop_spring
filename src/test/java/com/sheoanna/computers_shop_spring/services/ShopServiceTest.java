package com.sheoanna.computers_shop_spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.sheoanna.computers_shop_spring.dtos.ShopDto;
import com.sheoanna.computers_shop_spring.models.Computer;
import com.sheoanna.computers_shop_spring.models.Shop;
import com.sheoanna.computers_shop_spring.repositories.ShopRepository;

@ExtendWith(MockitoExtension.class)
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
        shop.setComputers(List.of(computer));
    }

    @Test
    void testIndex() {
        when(shopRepository.findAll()).thenReturn(List.of(shop));

        List<ShopDto> result = shopService.index();

        assertEquals(1, result.size());
        assertEquals(shop.getTaxID(), result.get(0).taxID());
        verify(shopRepository, times(1)).findAll();
    }
    @Test
    void testFindShopById() {
        when(shopRepository.findById(1L)).thenReturn(Optional.of(shop));

        ShopDto result = shopService.findShopById(1L);

        assertNotNull(result);
        assertEquals(shop.getStoreName(), result.storeName());
        verify(shopRepository, times(1)).findById(1L);

    }
}
