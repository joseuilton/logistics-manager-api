package com.softbrasinovacoes.logisticsmanager.services.imports.utils;

import java.util.List;

import com.softbrasinovacoes.logisticsmanager.domain.itens.Item;
import com.softbrasinovacoes.logisticsmanager.domain.products.Product;

public class ProductsAndItensColletion {
  private List<Product> products;
  private List<Item> itens;

  public ProductsAndItensColletion(List<Product> products, List<Item> itens) {
    this.products = products;
    this.itens = itens;
  }

  public List<Product> getProducts() {
    return this.products;
  }

  public List<Item> getItens() {
    return this.itens;
  }
}
