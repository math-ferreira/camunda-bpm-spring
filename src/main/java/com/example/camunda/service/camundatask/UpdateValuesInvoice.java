package com.example.camunda.service.camundatask;

import com.example.camunda.service.InvoiceService;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.camunda.utils.DelegateExecutionUtils.AMOUNT_TO_PAY;
import static com.example.camunda.utils.DelegateExecutionUtils.CUSTOMER_ID;

@Named
public class UpdateValuesInvoice implements JavaDelegate {

    private static final Logger logger = LoggerFactory.getLogger(UpdateValuesInvoice.class);

    private final InvoiceService invoiceService;

    public UpdateValuesInvoice(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Updating the invoice for the customer. Datetime: {}", LocalDateTime.now());

        var retrieveCustomerId = UUID.fromString(delegateExecution.getVariable(CUSTOMER_ID).toString());
        var amountPaid = new BigDecimal(delegateExecution.getVariable(AMOUNT_TO_PAY).toString());

        invoiceService.updateNextInvoice(
                retrieveCustomerId,
                amountPaid
        );

        logger.info("Invoice updated successfully. Datetime: {}", LocalDateTime.now());
    }
}
