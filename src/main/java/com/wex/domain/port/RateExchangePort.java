package com.wex.domain.port;

import com.wex.domain.model.ExchangeRate;

import java.time.LocalDate;
import java.util.List;

public interface RateExchangePort {
    List<ExchangeRate> get(LocalDate date);
}
