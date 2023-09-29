package com.wex.app.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderRequest {
    @NotNull
    private double amount;
    @Size(max = 50)
    private String description;
    @PastOrPresent
    @JsonFormat(pattern = "yyyy/MM/dd")
    @NotNull
    private LocalDate transactionDate;
}
