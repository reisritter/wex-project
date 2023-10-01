package com.wex.infra.adapter.out.treasury_api;

import com.wex.domain.model.ExchangeRate;
import com.wex.infra.adapter.out.treasury_api.dto.response.ResponseAPI;
import com.wex.infra.adapter.out.treasury_api.mapper.ExchangeRateMapper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RateExchangeAdapterTest {

    @InjectMocks
    private RateExchangeAdapter rateExchangeAdapter;
    @Mock
    private RestTemplate restTemplate;
    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void testSucess(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        LocalDate date = LocalDate.now();
        String dateS = date.minusMonths(6).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String url = "https://api.fiscaldata.treasury.gov/services/api/fiscal_service/v1/accounting/od/rates_of_exchange";
        String fields = "?fields=record_date,country,currency,exchange_rate";
        String filter = "&filter=effective_date:gte:"+dateS;
        String page = "&page[size]=1000";
        String urlComp = url+fields+filter+page;

        ResponseAPI responseAPI = easyRandom.nextObject(ResponseAPI.class);
        responseAPI.getData().forEach(x->x.setRate("100"));
        ResponseEntity<ResponseAPI> responseEntity = new ResponseEntity<>(responseAPI,HttpStatus.OK);

        when(restTemplate.exchange(urlComp,HttpMethod.GET,new HttpEntity<>(headers),ResponseAPI.class)).thenReturn(responseEntity);

        List<ExchangeRate> exchangeRateList = rateExchangeAdapter.get(date);

        assertEquals(responseAPI.getData().stream().map(ExchangeRateMapper.INSTANCE::mapFrom).toList(),exchangeRateList);
    }

}