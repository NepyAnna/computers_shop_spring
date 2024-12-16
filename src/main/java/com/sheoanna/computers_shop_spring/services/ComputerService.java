package com.sheoanna.computers_shop_spring.services;

import org.springframework.stereotype.Service;

import com.sheoanna.computers_shop_spring.repositories.ComputerRepository;


@Service
public class ComputerService {
    private ComputerRepository repository;

    public ComputerService(ComputerRepository repository) {
        this.repository = repository;
    }
}
