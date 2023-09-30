package com.wex.domain.service;

import com.wex.app.controller.exception.WexBusinessException;
import com.wex.domain.mapper.ConvertedAmountMapper;
import com.wex.domain.model.ConvertedAmount;
import com.wex.domain.model.ExchangeRate;
import com.wex.domain.model.Order;
import com.wex.domain.port.OrderServicePort;
import com.wex.domain.port.RateExchangePort;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ConversionServiceTest {
    @Mock
    private RateExchangePort rateExchangePort;

    @Mock
    private OrderServicePort orderService;

    @InjectMocks
    private ConversionService conversionService;

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void shouldGetConvertedAmount() {

        Order order = easyRandom.nextObject(Order.class);
        List<ExchangeRate> exchangeRateList = easyRandom.objects(ExchangeRate.class,5).toList();
        ConvertedAmount convertedAmount = ConvertedAmountMapper.INSTANCE.mapFrom(exchangeRateList,order);

        when(orderService.get(1L)).thenReturn(order);
        when(rateExchangePort.get(order.getTransactionDate())).thenReturn(exchangeRateList);

        ConvertedAmount convertedAmountResponse = conversionService.get(1L);
        assertEquals(convertedAmount, convertedAmountResponse);
    }

    @Test
    void shouldThrowExceptionWhenOrderIsNull() {
        when(orderService.get(1L)).thenReturn(null);

        try {
            conversionService.get(1L);
            fail("Deveria ter lançado uma exceção.");
        } catch (WexBusinessException e) {
            assertEquals("It was not found. Order object is null", e.getMessage());
        }
    }
}