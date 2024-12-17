package com.sheoanna.computers_shop_spring.dtos;

import java.util.List;

public record ShopDto(Long id_shop, String storeName, int taxID, List<ComputerDto> computers) {
    
}
