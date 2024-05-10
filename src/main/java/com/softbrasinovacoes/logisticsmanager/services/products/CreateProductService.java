package com.softbrasinovacoes.logisticsmanager.services.products;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.products.Product;
import com.softbrasinovacoes.logisticsmanager.domain.products.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateProductService {
  private final ProductRepository productRepository;

  public Output execute(String name, String description, int price_in_cents) {
    var product = new Product(name, description, price_in_cents);
    productRepository.save(product);
    return new Output(
      product.getProduct_id(),
      product.getName(),
      product.getDescription(),
      product.getPrice_in_cents()
    );
  }
}

record Output(
  String product_id,
  String name,
  String description,
  int price_in_cents
){}
