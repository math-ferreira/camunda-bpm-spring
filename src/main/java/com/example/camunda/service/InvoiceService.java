package com.example.camunda.service;

import com.example.camunda.model.dto.InvoiceRequestDTO;
import com.example.camunda.model.dto.InvoiceResponseDTO;
import com.example.camunda.model.entities.InvoiceEntity;

import java.math.BigDecimal;
import java.util.UUID;

public interface InvoiceService {

    InvoiceResponseDTO sendInvoice(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceEntity saveInvoice(InvoiceRequestDTO invoiceRequestDTO, UUID invoiceId);

    void updateNextInvoice(UUID customerId, BigDecimal remainingBalance);

}
