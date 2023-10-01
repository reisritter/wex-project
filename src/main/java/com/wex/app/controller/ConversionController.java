package com.wex.app.controller;

import com.wex.domain.port.ConversionPort;
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
    @GetMapping("{id}/country")
    public ResponseEntity<?> getByCountry(@PathVariable Long id,
                                          @RequestParam(name = "country") String name){
        return new ResponseEntity<>(conversionPort.getByCountry(id,name), HttpStatus.OK);
    }
}
