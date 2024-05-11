package com.softbrasinovacoes.logisticsmanager.services.customers;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.customers.Customer;
import com.softbrasinovacoes.logisticsmanager.domain.customers.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetCustomerService {
  private final CustomerRepository customerRepository;

  public GetCustomerOutput execute(String id) {
    Optional<Customer> optionalCustomer = customerRepository.findById(id);

    if (optionalCustomer.isEmpty()) {
      throw new EntityNotFoundException("Customer not found");
    }

    var customer = optionalCustomer.get();

    return new GetCustomerOutput(
      id,
      customer.getName(),
      customer.getEmail(),
      customer.getPhone(),
      customer.getAddress(),
      customer.getCnpj()
    );
  } 
}

record GetCustomerOutput(
  String customer_id,
  String name,
  String email,
  String phone,
  String address,
  String cnpj
){}
