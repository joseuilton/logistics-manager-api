package com.softbrasinovacoes.logisticsmanager.services.customers;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.customers.Customer;
import com.softbrasinovacoes.logisticsmanager.domain.customers.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteCustomerService {
  private final CustomerRepository customerRepository;

  public void execute(String id) {
    Optional<Customer> optionalCustomer = customerRepository.findById(id);

    if (optionalCustomer.isEmpty()) {
      throw new EntityNotFoundException("Customer not found");
    }

    customerRepository.delete(optionalCustomer.get());
  }
}
