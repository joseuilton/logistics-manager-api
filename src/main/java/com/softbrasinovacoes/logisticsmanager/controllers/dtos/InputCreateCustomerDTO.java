package com.softbrasinovacoes.logisticsmanager.controllers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record InputCreateCustomerDTO(
  @NotEmpty
  String name,

  @NotEmpty
  @Email
  String email,

  @NotEmpty
  String phone,

  @NotEmpty()
  String address,
  
  @NotEmpty()
  String cnpj
) {};