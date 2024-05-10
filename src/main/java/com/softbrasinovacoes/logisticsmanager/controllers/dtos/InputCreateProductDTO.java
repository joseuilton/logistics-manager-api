package com.softbrasinovacoes.logisticsmanager.controllers.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record InputCreateProductDTO(
  @NotEmpty
  String name,
  @NotEmpty
  String description,
  @NotNull
  int price_in_cents
){}
