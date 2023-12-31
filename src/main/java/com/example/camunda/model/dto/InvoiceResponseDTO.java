package com.example.camunda.model.dto;

import java.util.UUID;

public record InvoiceResponseDTO(
        UUID userId,
        UUID invoiceId
) {
}
