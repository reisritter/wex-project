package com.wex.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExchangeRate {

    private String country;
    private String currency;
    private LocalDate effectiveDate;
    private double rate;
    private double updatedValue;
}
