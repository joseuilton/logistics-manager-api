package com.softbrasinovacoes.logisticsmanager.services.products;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.products.Product;
import com.softbrasinovacoes.logisticsmanager.domain.products.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteProductService {
  private final ProductRepository productRepository;

  public void execute(String id) {
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isEmpty()) {
      throw new EntityNotFoundException("Product not found");
    }

    productRepository.delete(optionalProduct.get());
  }
}
