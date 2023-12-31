package com.example.camunda.model.dto;

import java.math.BigDecimal;

public record BalanceResponseDTO(
        BigDecimal totalAmount,
        BigDecimal interestRate,
        String currency

) {
}
