package com.softbrasinovacoes.logisticsmanager.domain.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "product_id")
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.UUID)
  private String product_id;

  private String name;
  private String description;
  private int price_in_cents;

  public Product(String name, String description, int price_in_cents) {
    this.name = name;
    this.description = description;
    this.price_in_cents = price_in_cents;
  }
}
