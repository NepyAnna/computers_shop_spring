package com.sheoanna.computers_shop_spring.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sheoanna.computers_shop_spring.services.OwnerService;

@RestController
@RequestMapping("api-endpoint//owners")
public class OwnerController {
    private OwnerService service;

    public OwnerController(OwnerService service) {
        this.service = service;
    }
}
