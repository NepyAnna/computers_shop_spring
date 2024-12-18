package com.sheoanna.computers_shop_spring.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.sheoanna.computers_shop_spring.dtos.ShopDto;
import com.sheoanna.computers_shop_spring.services.ShopService;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    private ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<ShopDto> getAllShopsWithComputers() {
        return service.index();
    }

    @GetMapping("/{id}")
    public ShopDto getShopById(@PathVariable Long id) {
        return service.findShopById(id);
    }
}
