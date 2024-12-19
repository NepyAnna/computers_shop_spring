package com.sheoanna.computers_shop_spring.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.sheoanna.computers_shop_spring.models.Shop;
import com.sheoanna.computers_shop_spring.services.ComputerService;

@SuppressWarnings("removal")
@WebMvcTest(controllers = ComputerController.class)
@AutoConfigureMockMvc(addFilters = false)

public class ComputerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ComputerService computerService;

    @Test
    void testIndex() throws Exception {
        Shop testShop = new Shop();
        testShop.setId_shop(1L);
        ComputerDto compDtoData = new ComputerDto(1L, "Dell", "32GB", "Intel i7", "Windows 10", 1000,
                testShop.getId_shop());

        when(computerService.findAll()).thenReturn(List.of(compDtoData));

        mockMvc.perform(get("/api/computers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].brand").value("Dell"))
                .andExpect(jsonPath("$[0].id_shop").value("1"));
    }

    @Test
    void testGetByBrand() throws Exception {
        Shop testShop = new Shop();
        testShop.setId_shop(1L);
        ComputerDto compDtoData = new ComputerDto(1L, "Dell", "32GB", "Intel i7", "Windows 10", 1000,
                testShop.getId_shop());
        when(computerService.findByBrand("Dell")).thenReturn(List.of(compDtoData));

        mockMvc.perform(get("/api/computers/?brand=Dell"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$.[0].price").value(1000))
                .andExpect(jsonPath("$.[0].brand").value("Dell"));
    }

    @Test
    void testAddComputer() throws Exception {
        Shop testShop = new Shop();
        testShop.setId_shop(1L);

        ComputerDto compDtoData = new ComputerDto(1L, "Dell", "32GB", "Intel i7", "Windows 10", 1000.0,
                testShop.getId_shop());

        when(computerService.store(any(ComputerDto.class))).thenReturn(compDtoData);

        mockMvc.perform(post("/api/computers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "computer_id": 1,
                               "brand": "Dell",
                               "memorySize": "32GB",
                               "processorSpecification": "Intel i7",
                               "operatingSystem": "Windows 10",
                               "price": 1000.0,
                               "id_shop": 1
                           }
                        """))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.computer_id").value(1));
    }

    @Test
    void testDeleteComputer() throws Exception {
    doNothing().when(computerService).deleteByBrand("Dell");
    mockMvc.perform(delete("/api/computers/Dell"))
            .andExpect(status().isNoContent()); 
    }
}
