package com.softbrasinovacoes.logisticsmanager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softbrasinovacoes.logisticsmanager.controllers.dtos.InputCreateCustomerDTO;
import com.softbrasinovacoes.logisticsmanager.controllers.dtos.InputUpdateCustomerDTO;
import com.softbrasinovacoes.logisticsmanager.services.customers.CreateCustomerService;
import com.softbrasinovacoes.logisticsmanager.services.customers.GetAllCustomersService;
import com.softbrasinovacoes.logisticsmanager.services.customers.GetCustomerService;
import com.softbrasinovacoes.logisticsmanager.services.customers.UpdateCustomerService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomersController {
  private final GetAllCustomersService getAllCustomersService;
  private final GetCustomerService getCustomerService;
  private final CreateCustomerService createCustomerService;
  private final UpdateCustomerService updateCustomerService;

  @GetMapping
  public ResponseEntity getAllCustomers() {
    var customers = getAllCustomersService.execute();
    return ResponseEntity.ok(customers);
  }

  @GetMapping("/{id}")
  public ResponseEntity getCustomer(@PathVariable String id) {
    var customer = getCustomerService.execute(id);
    return ResponseEntity.ok(customer);
  }

  @PostMapping
  public ResponseEntity createCustomer(@RequestBody @Valid InputCreateCustomerDTO data) {
    var customer = createCustomerService.execute(
        data.name(),
        data.email(),
        data.phone(),
        data.address(),
        data.cnpj());
    return ResponseEntity.created(null).body(customer);
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity updateCustomer(
      @PathVariable String id,
      @RequestBody @Valid InputUpdateCustomerDTO data) {
    var customer = updateCustomerService.execute(id, data.name(), data.email(), data.phone(), data.address(), data.cnpj());

    return ResponseEntity.ok(customer);
  }

}
