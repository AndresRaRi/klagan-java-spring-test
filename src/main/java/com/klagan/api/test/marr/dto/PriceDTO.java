package com.klagan.api.test.marr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "PriceDTO", description = "DTO for representing price data")
public class PriceDTO {

    @ApiModelProperty(value = "Product ID", example = "1")
    private Long productId;

    @ApiModelProperty(value = "Brand ID", example = "1")
    private Long brandId;

    @ApiModelProperty(value = "Price List ID", example = "1")
    private Long priceList;

    @ApiModelProperty(value = "Start Date", example = "2023-11-02")
    private Date startDate;

    @ApiModelProperty(value = "End Date", example = "2023-11-02")
    private Date endDate;

    @ApiModelProperty(value = "Final Price", example = "35.50")
    private Double price;

    @ApiModelProperty(value = "Currency", example = "EUR")
    private String currency;

}
