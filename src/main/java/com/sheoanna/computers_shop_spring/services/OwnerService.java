package com.sheoanna.computers_shop_spring.services;

import org.springframework.stereotype.Service;

import com.sheoanna.computers_shop_spring.repositories.OwnerRepository;

@Service
public class OwnerService {
    private OwnerRepository repository;

    public OwnerService(OwnerRepository repository) {
        this.repository = repository;
    }
}
