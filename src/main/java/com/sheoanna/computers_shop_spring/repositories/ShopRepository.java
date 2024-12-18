package com.sheoanna.computers_shop_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sheoanna.computers_shop_spring.models.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
