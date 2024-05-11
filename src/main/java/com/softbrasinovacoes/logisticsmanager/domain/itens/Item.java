package com.softbrasinovacoes.logisticsmanager.domain.itens;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.softbrasinovacoes.logisticsmanager.domain.products.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "item")
@Entity(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "item_id")
public class Item {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long item_id;

  @Column(name = "ean_code")
  private String eanCode;

  @ManyToOne
  @JoinColumn(name = "product_id")
  @JsonBackReference
  private Product product;

  public Item(String ean_code, Product product) {
    this.eanCode = ean_code;
    this.product = product;
  }

  public Item(Product product) {
    this.product = product;
  }
}
