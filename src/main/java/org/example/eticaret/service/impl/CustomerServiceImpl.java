package org.example.eticaret.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.dto.CustomerDto;
import org.example.eticaret.entity.Customer;
import org.example.eticaret.repository.CustomerRepository;
import org.example.eticaret.service.CustomerService;
import org.example.eticaret.service.mapper.CustomerServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = CustomerServiceMapper.toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerServiceMapper.toDto(savedCustomer);
    }

    @Override
    public CustomerDto update(CustomerDto customerDto, Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());
        customer.setPassword(customerDto.getPassword());
        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerServiceMapper.toDto(updatedCustomer);
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return CustomerServiceMapper.toDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerServiceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
