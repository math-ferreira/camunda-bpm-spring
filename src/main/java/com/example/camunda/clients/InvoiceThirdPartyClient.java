package com.example.camunda.clients;

import com.example.camunda.model.dto.InvoiceRequestDTO;
import com.example.camunda.model.dto.InvoiceResponseDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InvoiceThirdPartyClient {

    /**
     * @param invoiceRequestDTO
     * @apiNote Interface default Method to simulate a third party integration
     */
    public InvoiceResponseDTO postSendInvoice(InvoiceRequestDTO invoiceRequestDTO) {
        return new InvoiceResponseDTO(
                invoiceRequestDTO.customerId(),
                UUID.randomUUID()
        );
    }

}
