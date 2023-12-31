package com.example.camunda.model.dto;

import com.example.camunda.model.enums.ContactTypeEnum;

import java.math.BigDecimal;
import java.util.UUID;

public record InvoiceRequestDTO(
        UUID customerId,
        String name,
        ContactTypeEnum contactTypeEnum,
        String contactValue,
        BigDecimal totalAmount,
        String currency

) {
}
