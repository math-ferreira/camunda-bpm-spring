package com.example.camunda.utils;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class DelegateExecutionUtils {

    private final DelegateExecution delegateExecution;
    public static final String MONTH_YEAR_REFERENCE = "monthYearReference";
    public static final String INVOICE_AMOUNT = "invoiceAmount";
    public static final String AMOUNT_TO_PAY = "amountToPay";
    public static final String REMAINING_AMOUNT = "remainingAmount";
    public static final String INTEREST_RATE = "interestRate";
    public static final String CUSTOMER_ID = "customerId";

    public DelegateExecutionUtils(DelegateExecution delegateExecution) {
        this.delegateExecution = delegateExecution;
    }

    public void setPayInvoiceProcessValues(BigDecimal value, UUID customerId) {
        var monthYearString = LocalDate.now().getMonth() + " / " + LocalDate.now().getYear();
        setVariable(MONTH_YEAR_REFERENCE, monthYearString);
        setVariable(INVOICE_AMOUNT, value.toString());
        setVariable(AMOUNT_TO_PAY, value.toString());
        setVariable(CUSTOMER_ID, customerId.toString());
    }

    public void setInterestRateProcessValues(BigDecimal remainingAmount, BigDecimal interestRate) {
        setVariable(REMAINING_AMOUNT, remainingAmount.toString());
        setVariable(INTEREST_RATE, interestRate.toString());
    }

    private void setVariable(String key, Object value) {
        delegateExecution.setVariable(key, value);
    }

}
