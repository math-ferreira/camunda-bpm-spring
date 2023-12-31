package com.example.camunda.model.entities;

import com.example.camunda.model.enums.ContactTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @apiNote Record to simulate an entity class which represents the Customer database table
 */
public record CustomerEntity(
        UUID id,
        String name,
        int age,
        boolean isActive,
        ContactTypeEnum contactTypeEnum,
        String contactValue,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
