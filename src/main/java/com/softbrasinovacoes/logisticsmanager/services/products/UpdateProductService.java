package com.softbrasinovacoes.logisticsmanager.services.products;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.products.Product;
import com.softbrasinovacoes.logisticsmanager.domain.products.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateProductService {
  private final ProductRepository productRepository;

  public UpdateProductOutput execute(
    String id,
    String name,
    String description,
    int price_in_cents
  ) {
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isEmpty()) {
      throw new EntityNotFoundException("Product not found");
    }

    var product = optionalProduct.get();

    if (name != null && !name.isEmpty()) product.setName(name);
    if (description != null && !description.isEmpty()) product.setDescription(description);
    if (price_in_cents != 0) product.setPrice_in_cents(price_in_cents);

    return new UpdateProductOutput(
      product.getProduct_id(),
      product.getName(),
      product.getDescription(),
      product.getPrice_in_cents()
    );
  }
}

record UpdateProductOutput(
  String product_id,
  String name,
  String description,
  int price_in_cents
){}
