package com.softbrasinovacoes.logisticsmanager.services.products;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.products.Product;
import com.softbrasinovacoes.logisticsmanager.domain.products.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetProductService {
  private final ProductRepository productRepository;

  public GetProductOutput execute(String id) {
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isEmpty()) {
      throw new EntityNotFoundException("Product not found");
    }

    var product = optionalProduct.get();
    return new GetProductOutput(
      id,
      product.getName(),
      product.getDescription(),
      product.getPrice_in_cents(),
      product.getItens().stream().map(item -> new ItemData(item.getItem_id(), item.getEanCode())).toList()
    );
  }
}

record ItemData(
  Long item_id,
  String ean_code
){}

record GetProductOutput(
  String product_id,
  String name,
  String description,
  int price_in_cents,
  List<ItemData> itens
)
{}
