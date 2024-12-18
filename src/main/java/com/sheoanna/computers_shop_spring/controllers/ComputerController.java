package com.sheoanna.computers_shop_spring.controllers;

import com.sheoanna.computers_shop_spring.dtos.ComputerDto;
import com.sheoanna.computers_shop_spring.services.ComputerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {
    private ComputerService service;

    public ComputerController(ComputerService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<ComputerDto>> index() {
        List<ComputerDto> computers = service.findAll();
        return ResponseEntity.ok(computers);
    }

    @GetMapping("/")
    public ResponseEntity<List<ComputerDto>> searchByBrand(@RequestParam String brand) {
        List<ComputerDto> computers = service.findByBrand(brand);
        return ResponseEntity.ok(computers);
    }

    @PostMapping("")
    public ResponseEntity<ComputerDto> addComputer(@RequestBody ComputerDto computer) {
        ComputerDto computerDto = service.store(computer);
        return ResponseEntity.ok(computerDto);
    }

    @DeleteMapping("/{brand}")
    public ResponseEntity<Void> deleteComputer(@PathVariable String brand) {
        try {
            service.deleteByBrand(brand);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}