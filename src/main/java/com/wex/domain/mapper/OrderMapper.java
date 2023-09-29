package com.wex.domain.mapper;

import com.wex.domain.model.Order;
import com.wex.infra.adapter.out.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderEntity mapFrom(Order order);

    Order mapFrom(OrderEntity order);

}
