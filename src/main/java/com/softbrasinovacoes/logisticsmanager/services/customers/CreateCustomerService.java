package com.softbrasinovacoes.logisticsmanager.services.customers;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.customers.Customer;
import com.softbrasinovacoes.logisticsmanager.domain.customers.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateCustomerService {
  private final CustomerRepository customerRepository;

  public CreateCustomerOutput execute(String name, String email, String phone, String address, String cnpj) {
    Customer customer = new Customer(
      name,
      email,
      phone,
      address,
      cnpj
    );
    customerRepository.save(customer);

    return new CreateCustomerOutput(
      customer.getCustomer_id(),
      customer.getName(),
      customer.getEmail(),
      customer.getPhone(),
      customer.getAddress(),
      customer.getCnpj()
    );
  }
}

record CreateCustomerOutput(
  String customer_id,
  String name,
  String email,
  String phone,
  String address,
  String cnpj
){}
