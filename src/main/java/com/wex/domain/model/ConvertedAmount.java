package com.wex.domain.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ConvertedAmount {

    private Long id;
    private String description;
    private LocalDate transactionDate;
    private double amount;
    private List<ExchangeRate> exchangeRateList;

}
