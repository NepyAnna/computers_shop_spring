package com.sheoanna.computers_shop_spring.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sheoanna.computers_shop_spring.models.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
    List<Computer> findByBrand(String brand);
    void deleteByBrand(String brand);
}