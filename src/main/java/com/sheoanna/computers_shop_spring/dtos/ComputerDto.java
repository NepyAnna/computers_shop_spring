package com.sheoanna.computers_shop_spring.dtos;

public record ComputerDto(Long computer_id, String brand, int memorySize, String processorSpecification, String operatingSystem, double price, Long id_shop) {}
