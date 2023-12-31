package com.example.camunda.service.impl;

import com.example.camunda.model.dto.UserDetailsDTO;
import com.example.camunda.model.enums.ContactTypeEnum;
import com.example.camunda.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    /**
     * Retrieves a list of customer details.
     *
     * @return List of UserDetailsDTO objects representing customer details.
     */
    @Override
    public List<UserDetailsDTO> getListOfCustomers() {

        return List.of(
                new UserDetailsDTO(
                        UUID.randomUUID(),
                        "Thomas P. Blake",
                        ContactTypeEnum.EMAIL,
                        "ThomasPBlake@teleworm.us"
                ),
                new UserDetailsDTO(
                        UUID.randomUUID(),
                        "Michael S. Campbell",
                        ContactTypeEnum.SMS,
                        "931-537-0265"
                ),
                new UserDetailsDTO(
                        UUID.randomUUID(),
                        "Dianne W. York",
                        ContactTypeEnum.EMAIL,
                        "DianneWYork@armyspy.com"
                ),
                new UserDetailsDTO(
                        UUID.randomUUID(),
                        "Jeanne P. Hoffman",
                        ContactTypeEnum.WHATSAPP,
                        "323-264-3822"
                ),
                new UserDetailsDTO(
                        UUID.randomUUID(),
                        "Ilene A. Hutchison",
                        ContactTypeEnum.WHATSAPP,
                        "972-965-2864"
                ),
                new UserDetailsDTO(
                        UUID.randomUUID(),
                        "Bryant D. Stephens",
                        ContactTypeEnum.SMS,
                        "662-384-6503"
                )
        );
    }
}
