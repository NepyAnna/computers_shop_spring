package com.sheoanna.computers_shop_spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sheoanna.computers_shop_spring.dtos.ComputerDto;
import com.sheoanna.computers_shop_spring.models.Computer;
import com.sheoanna.computers_shop_spring.models.Shop;
import com.sheoanna.computers_shop_spring.repositories.ComputerRepository;
import com.sheoanna.computers_shop_spring.repositories.ShopRepository;

public class ComputerServiceTest {
    @Mock
    private ComputerRepository computerRepository;

    @Mock
    private ShopRepository shopRepository;

    @InjectMocks
    private ComputerService computerService;

    private Shop testShop;
    private Computer testComputer;
    private ComputerDto testComputerDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testShop = new Shop();
        testShop.setId_shop(1L);
        
        testComputer = new Computer("BrandX", "16GB", "Intel i7", "Windows 10", 1200.00, testShop);
        testComputer.setComputer_id(1L);
        
        testComputerDto = new ComputerDto(
                testComputer.getComputer_id(),
                testComputer.getBrand(),
                testComputer.getMemorySize(),
                testComputer.getProcessorSpecification(),
                testComputer.getOperatingSystem(),
                testComputer.getPrice(),
                testComputer.getShop().getId_shop());
    }

    @Test
    void testDeleteByBrand() {

    }

    @Test
    void testFindAll() {
        when(computerRepository.findAll()).thenReturn(List.of(testComputer));

        List<ComputerDto> result = computerService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testComputerDto, result.get(0));
    }

    @Test
    void testFindByBrand() {

    }

    @Test
    void testStore() {

    }
}
