package com.klagan.api.test.marr.service;

import com.klagan.api.test.marr.dto.PriceDTO;
import com.klagan.api.test.marr.entity.Price;
import com.klagan.api.test.marr.exception.PriceNotFoundException;
import com.klagan.api.test.marr.repository.PriceRepository;
import com.klagan.api.test.marr.service.mapper.PriceMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private PriceMapper priceMapper;

    private PriceService priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceService = new PriceServiceImpl(priceRepository, priceMapper);
    }

    @Test
    void testGetPriceInfoFound() {
        Date date = new Date();
        Long productId = 1L;
        Long brandId = 35455L;

        Price price = new Price();
        price.setProductId(productId);
        price.setBrandId(brandId);
        List<Price> prices = new ArrayList<>();
        prices.add(price);

        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductId(productId);
        priceDTO.setBrandId(brandId);

        when(priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId, date, date)).thenReturn(prices);
        when(priceMapper.convertToDTO(price)).thenReturn(priceDTO);

        PriceDTO result = priceService.getPriceInfo(date, productId, brandId);
        assertEquals(priceDTO, result);
    }

    @Test
    void testGetPriceInfoNotFound() {
        Date date = new Date();
        Long productId = 1L;
        Long brandId = 35455L;

        List<Price> prices = new ArrayList<>();

        when(priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId, date, date)).thenReturn(prices);
        assertThrows(PriceNotFoundException.class, () -> priceService.getPriceInfo(date, productId, brandId));
    }
}

