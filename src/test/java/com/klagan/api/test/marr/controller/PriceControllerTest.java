package com.klagan.api.test.marr.controller;

import com.klagan.api.test.marr.dto.PriceDTO;
import com.klagan.api.test.marr.exception.PriceNotFoundException;
import com.klagan.api.test.marr.service.PriceService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.http.ResponseEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceControllerTest {

    @Mock
    private PriceService priceService;

    private PriceController priceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceController = new PriceController(priceService);
    }

    @Test
    void testGetPriceInfo() {
        Date date = new Date();
        Long productId = 1L;
        Long brandId = 35455L;
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductId(productId);
        priceDTO.setBrandId(brandId);

        Mockito.when(priceService.getPriceInfo(date, productId, brandId)).thenReturn(priceDTO);

        ResponseEntity<PriceDTO> response = priceController.getPriceInfo(date, productId, brandId);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(priceDTO, response.getBody());
    }

    @Test
    void testGetPriceInfoAt10AM() throws ParseException {
        Date date = createDate("2020-06-14T10:00:00");
        Long productId = 35455L;
        Long brandId = 1L;

        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductId(productId);
        priceDTO.setBrandId(brandId);

        Mockito.when(priceService.getPriceInfo(date, productId, brandId)).thenReturn(priceDTO);
        ResponseEntity<PriceDTO> response = priceController.getPriceInfo(date, productId, brandId);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(priceDTO, response.getBody());
    }

    @Test
    void testGetPriceInfoAt4PM() throws ParseException {
        Date date = createDate("2020-06-14T16:00:00");
        Long productId = 35455L;
        Long brandId = 1L;

        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductId(productId);
        priceDTO.setBrandId(brandId);

        Mockito.when(priceService.getPriceInfo(date, productId, brandId)).thenReturn(priceDTO);
        ResponseEntity<PriceDTO> response = priceController.getPriceInfo(date, productId, brandId);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(priceDTO, response.getBody());
    }

    @Test
    void testGetPriceInfoAt9PM() throws ParseException {
        Date date = createDate("2020-06-14T21:00:00");
        Long productId = 35455L;
        Long brandId = 1L;

        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductId(productId);
        priceDTO.setBrandId(brandId);

        Mockito.when(priceService.getPriceInfo(date, productId, brandId)).thenReturn(priceDTO);
        ResponseEntity<PriceDTO> response = priceController.getPriceInfo(date, productId, brandId);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(priceDTO, response.getBody());
    }

    @Test
    void testGetPriceInfoNextDay() throws ParseException {
        Date date = createDate("2020-06-15T10:00:00");
        Long productId = 35455L;
        Long brandId = 1L;

        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductId(productId);
        priceDTO.setBrandId(brandId);

        Mockito.when(priceService.getPriceInfo(date, productId, brandId)).thenReturn(priceDTO);
        ResponseEntity<PriceDTO> response = priceController.getPriceInfo(date, productId, brandId);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(priceDTO, response.getBody());
    }

    @Test
    void testGetPriceInfoNextDayAfter9PM() throws ParseException {
        Date date = createDate("2020-06-15T21:00:00");
        Long productId = 35455L;
        Long brandId = 1L;

        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setProductId(productId);
        priceDTO.setBrandId(brandId);

        Mockito.when(priceService.getPriceInfo(date, productId, brandId)).thenReturn(priceDTO);
        ResponseEntity<PriceDTO> response = priceController.getPriceInfo(date, productId, brandId);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(priceDTO, response.getBody());
    }

    @Test
    void testGetPriceInfoNotFound() {
        Date date = new Date();
        Long productId = 1L;
        Long brandId = 35455L;

        Mockito.when(priceService.getPriceInfo(date, productId, brandId))
                .thenThrow(new PriceNotFoundException("Price not found"));
        assertThrows(PriceNotFoundException.class, () -> priceController.getPriceInfo(date, productId, brandId));
    }

    public Date createDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return dateFormat.parse(dateStr);
    }

}
