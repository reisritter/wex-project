package com.wex.app.controller.mapper;

import com.wex.domain.model.Order;
import com.wex.app.controller.dto.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapFrom(OrderRequest orderRequest);

}
