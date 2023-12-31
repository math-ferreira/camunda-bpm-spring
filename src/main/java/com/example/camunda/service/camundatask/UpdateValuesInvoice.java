package com.example.camunda.service.camundatask;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
public class UpdateValuesInvoice implements JavaDelegate {

    private static final Logger logger = LoggerFactory.getLogger(UpdateValuesInvoice.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Next invoice amount updated");
    }
}
