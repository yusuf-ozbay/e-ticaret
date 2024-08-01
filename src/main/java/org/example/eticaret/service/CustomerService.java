package org.example.eticaret.service;

import org.example.eticaret.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto save(CustomerDto customerDto);
    CustomerDto update(CustomerDto customerDto , Long id);
    CustomerDto getCustomer(Long id);
    List<CustomerDto> getAllCustomer();
    void delete(Long id);
}
