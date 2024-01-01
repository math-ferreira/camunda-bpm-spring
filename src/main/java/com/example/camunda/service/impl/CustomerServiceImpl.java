package com.example.camunda.service.impl;

import com.example.camunda.model.dto.CustomerDetailsDTO;
import com.example.camunda.model.enums.ContactTypeEnum;
import com.example.camunda.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    /**
     * Retrieves a customer details.
     *
     * @return UserDetailsDTO object representing customer details.
     */
    @Override
    public CustomerDetailsDTO getCustomer() {
        return new CustomerDetailsDTO(
                UUID.randomUUID(),
                "Dianne W. York",
                ContactTypeEnum.EMAIL,
                "DianneWYork@armyspy.com"
        );
    }
}
