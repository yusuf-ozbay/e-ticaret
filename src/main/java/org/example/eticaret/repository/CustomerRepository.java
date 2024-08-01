package org.example.eticaret.repository;

import org.example.eticaret.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findCustomerByEmail(String email);

}
