package com.softbrasinovacoes.logisticsmanager.services.products;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.products.Product;
import com.softbrasinovacoes.logisticsmanager.domain.products.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetProductService {
  private final ProductRepository productRepository;

  public Output execute(String id) {
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isEmpty()) {
      throw new EntityNotFoundException("Product not found");
    }

    var product = optionalProduct.get();
    return new Output(
      id,
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
  int price_in_cents)
{}
