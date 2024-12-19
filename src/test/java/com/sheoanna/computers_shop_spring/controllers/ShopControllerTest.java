package com.sheoanna.computers_shop_spring.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.sheoanna.computers_shop_spring.dtos.ComputerDto;
import com.sheoanna.computers_shop_spring.dtos.ShopDto;
import com.sheoanna.computers_shop_spring.services.ShopService;

@SuppressWarnings("removal")
@WebMvcTest(controllers = ShopController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ShopControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ShopService shopService;

    @Test
    void testIndex() throws Exception {
        ComputerDto computerDto = new ComputerDto(1L, "Dell", "32GB", "Intel i7", "Windows 10", 1000.0,
                1L);
        ShopDto testShop = new ShopDto(1L, "Tech Store", 1234567, List.of(computerDto));

        when(shopService.findAll()).thenReturn(List.of(testShop));

        mockMvc.perform(get("/api/shops"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(1));
    }

    @Test
    void testGetShopById() throws Exception {
        ComputerDto computerDto = new ComputerDto(1L, "Dell", "32GB", "Intel i7", "Windows 10", 1000.0,
                1L);
        ShopDto testShop = new ShopDto(1L, "Tech Store", 1234567, List.of(computerDto));

        when(shopService.findShopById(1L)).thenReturn(testShop);

        mockMvc.perform(get("/api/shops/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.storeName").value("Tech Store"));
    }
}
