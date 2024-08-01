package org.example.eticaret.controller;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.controller.mapper.CustomerControllerMapper;
import org.example.eticaret.dto.CustomerDto;
import org.example.eticaret.request.CustomerRequest;
import org.example.eticaret.response.CustomerResponse;
import org.example.eticaret.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("create")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerDto customerDto = CustomerControllerMapper.toDto(customerRequest);
        return ResponseEntity.ok(CustomerControllerMapper.toResponse(customerService.save(customerDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerRequest customerRequest) {
        CustomerDto customerDto = CustomerControllerMapper.toDto(customerRequest);
        CustomerDto updatedCustomer = customerService.update(customerDto, id);
        return ResponseEntity.ok(CustomerControllerMapper.toResponse(updatedCustomer));
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") Long id) {
        CustomerDto customerDto = customerService.getCustomer(id);
        return ResponseEntity.ok(CustomerControllerMapper.toResponse(customerDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerDto> customerDtoList = customerService.getAllCustomer();
        List<CustomerResponse> customerResponseList = customerDtoList.stream()
                .map(CustomerControllerMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
