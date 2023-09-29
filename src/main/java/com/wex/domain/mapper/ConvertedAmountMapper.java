package com.wex.domain.mapper;

import com.wex.domain.model.ConvertedAmount;
import com.wex.domain.model.ExchangeRate;
import com.wex.domain.model.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.text.DecimalFormat;
import java.util.List;

@Mapper
public interface ConvertedAmountMapper {

    ConvertedAmountMapper INSTANCE = Mappers.getMapper(ConvertedAmountMapper.class);

    @Mapping(target = "exchangeRateList", source = "list")
    ConvertedAmount mapFrom(List<ExchangeRate> list, Order order);

    @AfterMapping
    default void afterMapping(@MappingTarget ConvertedAmount convertedAmount,Order order){
        var value = order.getAmount();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setMaximumFractionDigits(2);
        convertedAmount.getExchangeRateList().forEach(x->
                x.setUpdatedValue(
                        Double.parseDouble(decimalFormat.format(value*x.getRate()).replace(',','.'))
                ));
    }
}
