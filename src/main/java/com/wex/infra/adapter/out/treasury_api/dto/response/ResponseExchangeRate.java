package com.wex.infra.adapter.out.treasury_api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseExchangeRate {

    @JsonProperty("country")
    private String country;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("record_date")
    private LocalDate effectiveDate;
    @JsonProperty("exchange_rate")
    private String rate;
}
