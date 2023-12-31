package com.example.camunda.service.impl;

import com.example.camunda.model.dto.BalanceResponseDTO;
import com.example.camunda.service.AccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public BalanceResponseDTO getCustomerBalance(UUID customerId) {
        return new BalanceResponseDTO(
                BigDecimal.valueOf(322.23),
                BigDecimal.valueOf(0.0),
                "$"
        );
    }
}
