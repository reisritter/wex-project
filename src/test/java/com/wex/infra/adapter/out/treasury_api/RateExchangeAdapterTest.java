package com.wex.infra.adapter.out.treasury_api;

import com.wex.app.controller.exception.WexBusinessException;
import com.wex.domain.model.ExchangeRate;
import com.wex.infra.adapter.out.treasury_api.dto.response.ResponseAPI;
import com.wex.infra.adapter.out.treasury_api.dto.response.ResponseExchangeRate;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
class RateExchangeAdapterTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RateExchangeAdapter rateExchangeAdapter;

    private final EasyRandom easyRandom = new EasyRandom();

}