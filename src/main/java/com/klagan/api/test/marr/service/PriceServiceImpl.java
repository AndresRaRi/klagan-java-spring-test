package com.klagan.api.test.marr.service;

import com.klagan.api.test.marr.dto.PriceDTO;
import com.klagan.api.test.marr.entity.Price;
import com.klagan.api.test.marr.exception.PriceNotFoundException;
import com.klagan.api.test.marr.repository.PriceRepository;
import com.klagan.api.test.marr.service.mapper.PriceMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private final transient PriceRepository priceRepository;
    private final transient PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public PriceDTO getPriceInfo(Date date, Long productId, Long brandId) {
        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                brandId, productId, date, date);

        return prices.stream()
                .findFirst()
                .map(priceMapper::convertToDTO)
                .orElseThrow(() -> new PriceNotFoundException("Price not found"));
    }

}
