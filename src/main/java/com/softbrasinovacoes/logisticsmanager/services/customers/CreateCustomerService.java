package com.softbrasinovacoes.logisticsmanager.services.customers;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.customers.Customer;
import com.softbrasinovacoes.logisticsmanager.domain.customers.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateCustomerService {
  private final CustomerRepository customerRepository;

  public Output execute(String name, String email, String phone, String address, String cnpj) {
    System.out.println("================================================");
    System.out.println(name);
    System.out.println("================================================");
    Customer customer = new Customer(
      name,
      email,
      phone,
      address,
      cnpj
    );
    System.out.println(customer);
    customerRepository.save(customer);

    return new Output(
      customer.getCustomer_id(),
      customer.getName(),
      customer.getEmail(),
      customer.getPhone(),
      customer.getAddress(),
      customer.getCnpj()
    );
  }
}

record Output(
  String customer_id,
  String name,
  String email,
  String phone,
  String address,
  String cnpj
){}
