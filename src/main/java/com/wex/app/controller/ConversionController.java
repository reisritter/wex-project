package com.wex.app.controller;

import com.wex.domain.port.ConversionPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
