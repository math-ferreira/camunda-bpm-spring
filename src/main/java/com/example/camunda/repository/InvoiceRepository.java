package com.example.camunda.repository;

import com.example.camunda.model.entities.InvoiceEntity;

public interface InvoiceRepository {

    InvoiceEntity save(InvoiceEntity invoiceEntity);

}
