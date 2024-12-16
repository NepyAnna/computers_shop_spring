package com.sheoanna.computers_shop_spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sheoanna.computers_shop_spring.services.ShopService;


@RestController
@RequestMapping("/shops")
public class ShopController {
    private ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }
}
