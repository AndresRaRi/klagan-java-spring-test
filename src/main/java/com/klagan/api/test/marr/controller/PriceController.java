package com.klagan.api.test.marr.controller;

import com.klagan.api.test.marr.dto.PriceDTO;
import com.klagan.api.test.marr.service.PriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/prices")
@Api(value = "Price Controller")
public class PriceController {

    private final transient PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    @ApiOperation(value = "Get Price Information", notes = "Get price information for a given date, product, and brand.")
    public ResponseEntity<PriceDTO> getPriceInfo(
            @ApiParam(value = "Date to get", example = "2020-06-14 15:00:00", required = true)
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            Date date,
            @ApiParam(value = "Product ID", example = "35455", required = true)
            @RequestParam
            Long productId,
            @ApiParam(value = "Brand ID", example = "1", required = true)
            @RequestParam
            Long brandId) {
        return ResponseEntity.ok(priceService.getPriceInfo(date, productId, brandId));
    }
}
