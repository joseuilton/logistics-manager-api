package com.softbrasinovacoes.logisticsmanager.services.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.customers.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetAllCustomersService {
  private final CustomerRepository customerRepository;

  public List<Output> execute() {
    var customers = customerRepository.findAll();
    List<Output> output = customers.stream().map(customer -> new Output(
      customer.getCustomer_id(),
      customer.getName(),
      customer.getEmail(),
      customer.getPhone(),
      customer.getAddress(),
      customer.getCnpj()
    )).toList();

    return output;
  }
}

record Output(
  String customerId,
  String name,
  String email,
  String phone,
  String address,
  String cnpj
) {}
