package com.example.camunda.service;

import com.example.camunda.model.dto.UserDetailsDTO;

import java.util.List;

public interface CustomerService {

    List<UserDetailsDTO> getListOfCustomers();

}
