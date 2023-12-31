package com.example.camunda.model.dto;

import com.example.camunda.model.enums.ContactTypeEnum;

import java.util.UUID;

public record CustomerDetailsDTO(
        UUID customerId,
        String name,
        ContactTypeEnum contactTypeEnum,
        String contactValue
) {
}
