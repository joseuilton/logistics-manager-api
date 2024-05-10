package com.softbrasinovacoes.logisticsmanager.controllers.dtos;

public record InputUpdateProductDTO(
  String name,
  String description,
  int price_in_cents
){}
