package org.example.eticaret.controller.mapper;

import org.example.eticaret.dto.CustomerDto;
import org.example.eticaret.request.CustomerRequest;
import org.example.eticaret.response.CustomerResponse;

public class CustomerControllerMapper {

    public static CustomerDto toDto(CustomerRequest customerRequest) {
        return CustomerDto.builder()
                .name(customerRequest.getName())
                .surname(customerRequest.getSurname())
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .address(customerRequest.getAddress())
                .password(customerRequest.getPassword())
                .build();
    }

    public static CustomerResponse toResponse(CustomerDto customerDto) {
        return CustomerResponse.builder()
                .id(customerDto.getCustomerId())
                .name(customerDto.getName())
                .surname(customerDto.getSurname())
                .email(customerDto.getEmail())
                .phoneNumber(customerDto.getPhoneNumber())
                .address(customerDto.getAddress())
                .build();
    }
}
