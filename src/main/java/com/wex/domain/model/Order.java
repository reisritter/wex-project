package com.wex.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Order {
    private Long id;
    private String description;
    private LocalDate transactionDate;
    private double amount;

}
