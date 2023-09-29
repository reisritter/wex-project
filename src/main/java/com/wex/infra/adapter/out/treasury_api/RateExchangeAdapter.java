package com.wex.infra.adapter.out.treasury_api;

import com.wex.app.controller.exception.WexBusinessException;
import com.wex.domain.model.ExchangeRate;
import com.wex.domain.port.RateExchangePort;
import com.wex.infra.adapter.out.treasury_api.dto.response.ResponseAPI;
import com.wex.infra.adapter.out.treasury_api.mapper.ExchangeRateMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class RateExchangeAdapter implements RateExchangePort {
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<ExchangeRate> get(LocalDate date){

        ResponseEntity<ResponseAPI> responseEntity = restTemplate.exchange(getUrl(date), HttpMethod.GET, new HttpEntity<>(getHeader()),ResponseAPI.class);
        var response = validateResponse(responseEntity);
        return response.getData().stream().map(ExchangeRateMapper.INSTANCE::mapFrom).toList();
    }

    private ResponseAPI validateResponse(ResponseEntity<ResponseAPI> responseEntity){
        var response = responseEntity.getBody();
        if(response==null || response.getData().isEmpty())
            throw new WexBusinessException("The return of API is empty");
        return response;
    }

    private HttpHeaders getHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private String getUrl(LocalDate date){
        String url = "https://api.fiscaldata.treasury.gov/services/api/fiscal_service/v1/accounting/od/rates_of_exchange";
        String fields = "?fields=record_date,country,currency,exchange_rate";
        String filter = "&filter=effective_date:gte:"+getSixMonthsBefore(date);
        return url+fields+filter;
    }

    private String getSixMonthsBefore(LocalDate date){
        return date.minusMonths(6).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }


}
