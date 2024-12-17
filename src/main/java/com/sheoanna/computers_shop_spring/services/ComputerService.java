package com.sheoanna.computers_shop_spring.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sheoanna.computers_shop_spring.dtos.ComputerDto;
import com.sheoanna.computers_shop_spring.models.Computer;
import com.sheoanna.computers_shop_spring.models.Shop;
import com.sheoanna.computers_shop_spring.repositories.ComputerRepository;
import com.sheoanna.computers_shop_spring.repositories.ShopRepository;
import jakarta.transaction.Transactional;

@Service
public class ComputerService {
    private ComputerRepository repository;
    private final ShopRepository shopRepository;

    public ComputerService(ComputerRepository repository, ShopRepository shopRepository) {
        this.repository = repository;
        this.shopRepository = shopRepository;
    }

    public List<ComputerDto> findAll() {
        return repository.findAll().stream()
                .map(computer -> new ComputerDto(
                        computer.getComputer_id(),
                        computer.getBrand(),
                        computer.getMemorySize(),
                        computer.getProcessorSpecification(),
                        computer.getOperatingSystem(),
                        computer.getPrice(),
                        computer.getShop() != null ? computer.getShop().getId_shop() : null))
                .toList();
    }

    public List<ComputerDto> findByBrand(String brand) {
        return repository.findByBrand(brand).stream()
                .map(computer -> new ComputerDto(
                        computer.getComputer_id(),
                        computer.getBrand(),
                        computer.getMemorySize(),
                        computer.getProcessorSpecification(),
                        computer.getOperatingSystem(),
                        computer.getPrice(),
                        computer.getShop() != null ? computer.getShop().getId_shop() : null))
                .toList();
    }

    @Transactional
    public ComputerDto store(ComputerDto newComputerData) {
        Shop shop = shopRepository.findById(newComputerData.id_shop())
                .orElseThrow(() -> new RuntimeException("Shop id " + newComputerData.id_shop() + " not found!"));
        Computer newComputer = new Computer(
                newComputerData.brand(),
                newComputerData.memorySize(),
                newComputerData.processorSpecification(),
                newComputerData.operatingSystem(),
                newComputerData.price(),
                shop);

        Computer savedComputer = repository.save(newComputer);

        return new ComputerDto(
                savedComputer.getComputer_id(),
                savedComputer.getBrand(),
                savedComputer.getMemorySize(),
                savedComputer.getProcessorSpecification(),
                savedComputer.getOperatingSystem(),
                savedComputer.getPrice(),
                savedComputer.getShop().getId_shop());
    }

    public void deleteByBrand(String brand) {
        List<Computer> computers = repository.findByBrand(brand);
        if (!computers.isEmpty()) {
            repository.deleteAll(computers);
        } else {
            throw new RuntimeException("No computers found with brand: " + brand);
        }
    }
}
