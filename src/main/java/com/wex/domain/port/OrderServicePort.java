package com.wex.domain.port;

import com.wex.domain.model.Order;

public interface OrderServicePort {
    Order save(Order order);
    Order get(Long id);
}
