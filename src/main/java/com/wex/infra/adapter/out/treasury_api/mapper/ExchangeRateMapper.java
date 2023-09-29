package com.wex.infra.adapter.out.treasury_api.mapper;

import com.wex.domain.model.ExchangeRate;
import com.wex.infra.adapter.out.treasury_api.dto.response.ResponseExchangeRate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeRateMapper {

    ExchangeRateMapper INSTANCE = Mappers.getMapper(ExchangeRateMapper.class);

    ExchangeRate mapFrom(ResponseExchangeRate responseExchangeRate);
}
