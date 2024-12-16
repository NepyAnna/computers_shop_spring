package com.sheoanna.computers_shop_spring.services;

import org.springframework.stereotype.Service;

import com.sheoanna.computers_shop_spring.repositories.ShopRepository;

@Service
public class ShopService {
    private ShopRepository repository;

    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }
}
