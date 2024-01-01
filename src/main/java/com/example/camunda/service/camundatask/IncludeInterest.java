package com.example.camunda.service.camundatask;

import com.example.camunda.utils.DelegateExecutionUtils;
import jakarta.inject.Named;
import org.camunda.bpm.engine.impl.pvm.delegate.ActivityBehavior;
import org.camunda.bpm.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.example.camunda.utils.DelegateExecutionUtils.AMOUNT_TO_PAY;

@Named
public class IncludeInterest implements ActivityBehavior {

    private static final Logger logger = LoggerFactory.getLogger(IncludeInterest.class);

    @Override
    public void execute(ActivityExecution activityExecution) throws Exception {
        logger.info("Including interest rate for the customer. Datetime: {}", LocalDateTime.now());

        var amountPaid = new BigDecimal(activityExecution.getVariable(AMOUNT_TO_PAY).toString());

        var interestRate = new BigDecimal("0.7");
        var interestRateAmount = amountPaid.multiply(interestRate);

        DelegateExecutionUtils delegateExecutionUtils = new DelegateExecutionUtils(activityExecution);
        delegateExecutionUtils.setInterestRateProcessValues(amountPaid.add(interestRateAmount), interestRate);

        logger.info("Interest rate included successfully. Datetime: {}", LocalDateTime.now());
    }
}
