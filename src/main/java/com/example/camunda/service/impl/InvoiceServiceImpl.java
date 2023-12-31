package com.example.camunda.service.impl;

import com.example.camunda.clients.InvoiceThirdPartyClient;
import com.example.camunda.model.dto.InvoiceRequestDTO;
import com.example.camunda.model.dto.InvoiceResponseDTO;
import com.example.camunda.model.entities.InvoiceEntity;
import com.example.camunda.repository.InvoiceRepository;
import com.example.camunda.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);
    private final InvoiceThirdPartyClient invoiceThirdPartyClient;
    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl() {
        this.invoiceThirdPartyClient = new InvoiceThirdPartyClient();
        this.invoiceRepository = invoiceEntity -> invoiceEntity;
    }

    @Override
    public InvoiceResponseDTO sendInvoice(InvoiceRequestDTO invoiceRequestDTO) {
        logger.info("sending invoice for customer contact. Customer id: {}, ContactType: {}",
                invoiceRequestDTO.customerId(),
                invoiceRequestDTO.contactTypeEnum()
        );
        return invoiceThirdPartyClient.postSendInvoice(invoiceRequestDTO);
    }

    @Override
    public InvoiceEntity saveInvoice(InvoiceRequestDTO invoiceRequestDTO, UUID invoiceId) {
        logger.info("Saving new invoice for the customer. Customer id: {}, Invoice id: {}",
                invoiceRequestDTO.customerId(),
                invoiceId
        );

        return invoiceRepository.save(
                new InvoiceEntity(
                        invoiceId,
                        invoiceRequestDTO.totalAmount(),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                )
        );

    }

}
