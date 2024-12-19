package com.sheoanna.computers_shop_spring.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sheoanna.computers_shop_spring.dtos.ShopDto;
import com.sheoanna.computers_shop_spring.services.ShopService;

@RestController
@RequestMapping("api/shops")
public class ShopController {
    private ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<ShopDto>> index() {
        List<ShopDto> shops = service.findAll();
        return ResponseEntity.ok(shops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> getShopById(@PathVariable Long id) {
        ShopDto shopById = service.findShopById(id);
        return ResponseEntity.ok(shopById);
    }
}
