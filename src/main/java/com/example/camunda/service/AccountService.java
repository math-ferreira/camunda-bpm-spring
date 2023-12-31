package com.example.camunda.service;

import com.example.camunda.model.dto.BalanceResponseDTO;

import java.util.UUID;

public interface AccountService {

    BalanceResponseDTO getCustomerBalance(UUID customerId);

}
