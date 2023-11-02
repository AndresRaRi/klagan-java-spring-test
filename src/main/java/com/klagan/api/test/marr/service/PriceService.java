package com.klagan.api.test.marr.service;

import com.klagan.api.test.marr.dto.PriceDTO;

import java.util.Date;

public interface PriceService {

    PriceDTO getPriceInfo(Date date, Long productId, Long brandId);

}
