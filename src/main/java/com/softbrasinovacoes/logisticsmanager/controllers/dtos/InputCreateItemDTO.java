package com.softbrasinovacoes.logisticsmanager.controllers.dtos;

import jakarta.validation.constraints.NotEmpty;

public record InputCreateItemDTO(
  @NotEmpty
  String cnpj
){}
