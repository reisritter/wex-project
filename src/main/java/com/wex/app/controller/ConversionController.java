package com.wex.app.controller;

import com.wex.app.controller.dto.OrderRequest;
import com.wex.app.controller.mapper.OrderMapper;
import com.wex.domain.model.Order;
import com.wex.domain.port.ConversionPort;
import com.wex.domain.port.OrderServicePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/conversion")
public class ConversionController {

    @Autowired
    private ConversionPort conversionPort;

    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return new ResponseEntity<>(conversionPort.get(id), HttpStatus.OK);
    }
}
