package com.softbrasinovacoes.logisticsmanager.services.customers;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.customers.Customer;
import com.softbrasinovacoes.logisticsmanager.domain.customers.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateCustomerService {
  private final CustomerRepository customerRepository;

  public Output execute(String id, String name, String email, String phone, String address, String cnpj) {
    Optional<Customer> optionalCustomer = customerRepository.findById(id);

    if (optionalCustomer.isEmpty()) {
      throw new EntityNotFoundException("Customer not found");
    }

    var customer = optionalCustomer.get();
    System.out.println("Passei por aqui");

    if (name != null && !name.isEmpty()) customer.setName(name);
    if (email != null && !email.isEmpty()) customer.setEmail(email);
    if (phone != null && !phone.isEmpty()) customer.setPhone(phone);
    if (address != null && !address.isEmpty()) customer.setAddress(address);

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
) {}
