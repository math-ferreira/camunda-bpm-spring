package com.example.camunda.service.camundatask;

import com.example.camunda.model.dto.InvoiceRequestDTO;
import com.example.camunda.service.AccountService;
import com.example.camunda.service.CustomerService;
import com.example.camunda.service.InvoiceService;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Named
public class SendInvoice implements JavaDelegate {

    private static final Logger logger = LoggerFactory.getLogger(SendInvoice.class);
    private final CustomerService customerService;
    private final AccountService accountService;
    private final InvoiceService invoiceService;

    public SendInvoice(
            CustomerService customerService,
            AccountService accountService,
            InvoiceService invoiceService
    ) {
        this.customerService = customerService;
        this.accountService = accountService;
        this.invoiceService = invoiceService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        logger.info("Starting to send invoice for the customers. Datetime: {}", LocalDateTime.now());

        customerService.getListOfCustomers().forEach(customer -> {
            var balance = accountService.getCustomerBalance(customer.customerId());

            var invoiceRequest = new InvoiceRequestDTO(
                    customer.customerId(),
                    customer.name(),
                    customer.contactTypeEnum(),
                    customer.contactValue(),
                    balance.totalAmount(),
                    balance.currency()
            );

            var invoiceResponse = invoiceService.sendInvoice(invoiceRequest);

            invoiceService.saveInvoice(invoiceRequest, invoiceResponse.invoiceId());
        });

        logger.info("Invoices sent successfully. Datetime: {}", LocalDateTime.now());

    }
}
