package com.klagan.api.test.marr.service.mapper;

import com.klagan.api.test.marr.dto.PriceDTO;
import com.klagan.api.test.marr.entity.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public PriceDTO convertToDTO(Price price) {
        PriceDTO dto = new PriceDTO();
        dto.setProductId(price.getProductId());
        dto.setBrandId(price.getBrandId());
        dto.setPriceList(price.getPriceList());
        dto.setStartDate(price.getStartDate());
        dto.setEndDate(price.getEndDate());
        dto.setPrice(price.getPrice());
        dto.setCurrency(price.getCurrency());
        return dto;
    }

}
