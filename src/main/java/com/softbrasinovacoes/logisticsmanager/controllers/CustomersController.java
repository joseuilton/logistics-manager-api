package com.softbrasinovacoes.logisticsmanager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softbrasinovacoes.logisticsmanager.services.customers.GetAllCustomersService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomersController {
  private final GetAllCustomersService getAllCustomersService;

  @GetMapping
  public ResponseEntity getAllCustomers() {
    var customers = getAllCustomersService.execute();
    return ResponseEntity.ok(customers);
  }
  
}
