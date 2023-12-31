package com.example.camunda.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @apiNote Record to simulate an entity class which represents the Invoice database table
 */
public record InvoiceEntity(
        UUID id,
        BigDecimal totalAmount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<CustomerEntity> customerEntityList
) {
}
