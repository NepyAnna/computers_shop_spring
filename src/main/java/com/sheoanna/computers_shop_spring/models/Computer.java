package com.sheoanna.computers_shop_spring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    private Long computer_id;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;

    @Column(name = "memory_size", nullable = false, length = 100)
    private int memorySize;

    @Column(name = "processor_specification", nullable = false, length = 100)
    private String processorSpecification;

    @Column(name = "operation_system", nullable = false, length = 100)
    private String operatingSystem;

    @Column(name = "price", nullable = false, length = 100)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shop")
    private Shop shop;

    public Computer(){}

    public Computer(String brand, int size, String specification, String operatingSystem, int price){
        this.brand =brand;
        this.memorySize = size;
        this.processorSpecification = specification;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }

    public Long getComputer_id() {
        return computer_id;
    }

    public String getBrand() {
        return brand;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public String getProcessorSpecification() {
        return processorSpecification;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public int getPrice() {
        return price;
    }
}
