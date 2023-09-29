package com.wex.domain.service;

import com.wex.app.controller.exception.WexBusinessException;
import com.wex.domain.mapper.ConvertedAmountMapper;
import com.wex.domain.model.ConvertedAmount;
import com.wex.domain.model.ExchangeRate;
import com.wex.domain.model.Order;
import com.wex.domain.port.ConversionPort;
import com.wex.domain.port.OrderServicePort;
import com.wex.domain.port.RateExchangePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ConversionService implements ConversionPort {

    @Autowired
    private RateExchangePort rateExchangePort;
    @Autowired
    private OrderServicePort orderService;

    @Override
    public ConvertedAmount get(Long id){
        Order order = orderService.get(id);
        if(Objects.isNull(order))
            throw new WexBusinessException("It was not found. Order object is null");
        List<ExchangeRate> exchangeRateList = rateExchangePort.get(order.getTransactionDate());
        return ConvertedAmountMapper.INSTANCE.mapFrom(exchangeRateList,order);
    }

}
