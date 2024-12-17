package com.sheoanna.computers_shop_spring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_computer")
    private Long computer_id;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;

    @Column(name = "memory_size", nullable = false, length = 100)
    private String memorySize;

    @Column(name = "processor_specification", nullable = false, length = 100)
    private String processorSpecification;

    @Column(name = "operation_system", nullable = false, length = 100)
    private String operatingSystem;

    @Column(name = "price", nullable = false, length = 100)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shop")
    @JsonBackReference
    private Shop shop;

    public Computer(){}

    public Computer(String brand, String size, String specification, String operatingSystem, double price, Shop shop){
        this.brand =brand;
        this.memorySize = size;
        this.processorSpecification = specification;
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.shop = shop;
    }

    public Long getComputer_id() {
        return computer_id;
    }

    public String getBrand() {
        return brand;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public String getProcessorSpecification() {
        return processorSpecification;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public Shop getShop() {
        return shop;
    }

    public void setComputer_id(Long id) {
        this.computer_id = id;
    }
}
