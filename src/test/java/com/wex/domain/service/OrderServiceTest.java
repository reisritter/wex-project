package com.wex.domain.service;

import com.wex.domain.mapper.OrderMapper;
import com.wex.domain.model.Order;
import com.wex.infra.adapter.out.persistence.entity.OrderEntity;
import com.wex.infra.adapter.out.persistence.repository.OrderRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void shouldSaveOrder() {

        Order order = easyRandom.nextObject(Order.class);
        OrderEntity orderEntity = OrderMapper.INSTANCE.mapFrom(order);
        when(orderRepository.save(orderEntity)).thenReturn(orderEntity);
        Order orderResponse = orderService.save(order);

        assertEquals(order, orderResponse);
    }

    @Test
    void shouldGetOrder() {

        OrderEntity orderEntity = easyRandom.nextObject(OrderEntity.class);
        when(orderRepository.findById(1L)).thenReturn(Optional.ofNullable(orderEntity));
        Order orderResponse = orderService.get(1L);

        assertEquals(OrderMapper.INSTANCE.mapFrom(orderEntity), orderResponse);
    }
}