package com.klagan.api.test.marr.repository;

import com.klagan.api.test.marr.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long brandId, Long productId, Date date, Date date2);

}
