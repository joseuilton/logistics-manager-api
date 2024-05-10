package com.softbrasinovacoes.logisticsmanager.controllers.dtos;

public record InputUpdateCustomerDTO(
  String name,
  String email,
  String phone,
  String address,
  String cnpj
) {}
