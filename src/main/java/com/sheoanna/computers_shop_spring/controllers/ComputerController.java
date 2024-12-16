package com.sheoanna.computers_shop_spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sheoanna.computers_shop_spring.services.ComputerService;

@RestController
@RequestMapping("/computers")
public class ComputerController {
    private ComputerService service;

    public ComputerController(ComputerService service) {
        this.service = service;
    }
}
