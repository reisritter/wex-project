package com.wex.domain.service;

import com.wex.domain.port.OrderServicePort;
import com.wex.domain.mapper.OrderMapper;
import com.wex.domain.model.Order;
import com.wex.infra.adapter.out.persistence.entity.OrderEntity;
import com.wex.infra.adapter.out.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServicePort {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = OrderMapper.INSTANCE.mapFrom(order);
        var response = orderRepository.save(orderEntity);
        return OrderMapper.INSTANCE.mapFrom(response);
    }

    @Override
    public Order get(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElse(null);
        return OrderMapper.INSTANCE.mapFrom(orderEntity);
    }
}
