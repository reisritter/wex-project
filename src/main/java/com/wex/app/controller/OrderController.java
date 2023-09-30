package com.wex.app.controller;

import com.wex.app.controller.dto.OrderRequest;
import com.wex.app.controller.mapper.OrderMapper;
import com.wex.domain.model.Order;
import com.wex.domain.port.OrderServicePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/order")
public class OrderController {

    @Autowired
    private OrderServicePort orderServicePort;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid OrderRequest orderRequest){

        Order order = OrderMapper.INSTANCE.mapFrom(orderRequest);
        return new ResponseEntity<>(orderServicePort.save(order), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        Order order = orderServicePort.get(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
