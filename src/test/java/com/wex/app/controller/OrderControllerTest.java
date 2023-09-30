package com.wex.app.controller;

import com.wex.app.controller.dto.OrderRequest;
import com.wex.app.controller.mapper.OrderMapper;
import com.wex.domain.model.Order;
import com.wex.domain.port.ConversionPort;
import com.wex.domain.port.OrderServicePort;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderServicePort orderServicePort;

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void testSaveOrderSucess(){

        OrderRequest request = easyRandom.nextObject(OrderRequest.class);
        Order order = OrderMapper.INSTANCE.mapFrom(request);

        when(orderServicePort.save(any(Order.class))).thenReturn(order);

        var result = orderController.save(request);
        Order body = (Order) result.getBody();

        assertNotNull(result);
        assertNotNull(body);
        assertEquals(HttpStatus.CREATED,result.getStatusCode());
        assertEquals(body,order);
    }

    @Test
    void testGetByIdOrderSucess(){

        Order order = easyRandom.nextObject(Order.class);

        when(orderServicePort.get(anyLong())).thenReturn(order);

        var result = orderController.get(1L);
        Order body = (Order) result.getBody();

        assertNotNull(result);
        assertNotNull(body);
        assertEquals(HttpStatus.OK,result.getStatusCode());
        assertEquals(body,order);
    }


}