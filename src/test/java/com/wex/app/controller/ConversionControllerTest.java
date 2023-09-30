package com.wex.app.controller;

import com.wex.domain.model.ConvertedAmount;
import com.wex.domain.port.ConversionPort;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
class ConversionControllerTest {

    @InjectMocks
    private ConversionController conversionController;
    @Mock
    private ConversionPort conversionPort;

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void testControllerSucess(){

        ConvertedAmount convertedAmount = easyRandom.nextObject(ConvertedAmount.class);
        when(conversionPort.get(1L)).thenReturn(convertedAmount);

        var result = conversionController.get(1L);
        ConvertedAmount body = (ConvertedAmount) result.getBody();

        assertNotNull(result);
        assertNotNull(body);
        assertEquals(HttpStatus.OK, result.getStatusCode());

        assertEquals(convertedAmount,body);
        assertEquals(convertedAmount.getExchangeRateList(),body.getExchangeRateList());
        assertEquals(convertedAmount.getAmount(),body.getAmount());
        assertEquals(convertedAmount.getDescription(),body.getDescription());
        assertEquals(convertedAmount.getTransactionDate(),body.getTransactionDate());
        assertEquals(convertedAmount.getId(),body.getId());
    }


}