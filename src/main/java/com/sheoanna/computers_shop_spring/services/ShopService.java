package com.sheoanna.computers_shop_spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.sheoanna.computers_shop_spring.dtos.ComputerDto;
import com.sheoanna.computers_shop_spring.dtos.ShopDto;
import com.sheoanna.computers_shop_spring.models.Shop;
import com.sheoanna.computers_shop_spring.repositories.ShopRepository;

@Service
public class ShopService {
    private ShopRepository repository;

    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    /*public List<ComputerDto> findAllByShop(Long shopId) {
        return repository.findAllDtoByShop(shopId);
    }*/

    public List<ShopDto> index() {
    List<Shop> shops = repository.findAll();
    return shops.stream().map(shop -> new ShopDto(shop.getId_shop(), shop.getStoreName(), shop.getTaxID(), 
        shop.getComputers().stream().map(computer -> new ComputerDto(
            computer.getComputer_id(), 
            computer.getBrand(), 
            computer.getMemorySize(),
            computer.getProcessorSpecification(),
            computer.getOperatingSystem(),
            computer.getPrice(), 
            computer.getShop() != null ? computer.getShop().getId_shop() : null
        )).collect(Collectors.toList())
    )).collect(Collectors.toList());
    }

}
