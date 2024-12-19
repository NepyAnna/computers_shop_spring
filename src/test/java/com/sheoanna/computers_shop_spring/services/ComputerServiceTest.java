package com.sheoanna.computers_shop_spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;
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
        
        testComputer = new Computer("Dell", "16GB", "Intel i7", "Windows 10", 1200.00, testShop);
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
        String brand = "Dell";
        when(computerRepository.findByBrand(brand)).thenReturn(List.of(testComputer));

        computerService.deleteByBrand(brand);

        verify(computerRepository, times(1)).deleteAll(anyList());
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
        String brand = "Dell";
        when(computerRepository.findByBrand(brand)).thenReturn(List.of(testComputer));

        List<ComputerDto> result = computerService.findByBrand(brand);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testComputerDto, result.get(0));
    }

    @Test
    @Transactional
    void testStore() {
        ComputerDto newComputerDto = new ComputerDto(
                1L, "Dell", "16GB", "AMD Ryzen", "Linux", 800.00, 1L);
        
        when(shopRepository.findById(1L)).thenReturn(Optional.of(testShop));
        when(computerRepository.save(any(Computer.class))).thenReturn(testComputer);

        ComputerDto result = computerService.store(newComputerDto);

        assertNotNull(result);
        assertEquals(newComputerDto.brand(), result.brand());
        assertEquals(newComputerDto.memorySize(), result.memorySize());
        assertEquals(testShop.getId_shop(), result.id_shop());
    }
}
