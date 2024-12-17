package com.sheoanna.computers_shop_spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sheoanna.computers_shop_spring.dtos.ComputerDto;
import com.sheoanna.computers_shop_spring.services.ComputerService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api-endpoint/computers")
public class ComputerController {
    private ComputerService service;

    public ComputerController(ComputerService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<ComputerDto> index() {
        List<ComputerDto> computers = service.findAll();
        return computers;
    }

    @GetMapping("/search")
    public List<ComputerDto> searchByBrand(@RequestParam String brand) {
        return service.findByBrand(brand);
    }

    @PostMapping("")
    public ComputerDto addComputer(@RequestBody ComputerDto computer) {
        return service.store(computer);
    }

    @DeleteMapping("/brand/{brand}")
    public void deleteComputer(@PathVariable String brand) {
        service.deleteByBrand(brand);
    }
}
