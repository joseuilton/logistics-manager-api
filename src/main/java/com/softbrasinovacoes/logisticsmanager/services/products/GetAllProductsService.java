package com.softbrasinovacoes.logisticsmanager.services.products;

import java.util.List;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.products.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetAllProductsService {
  private final ProductRepository productRepository;

  public List<Output> execute() {
    var products = productRepository.findAll();
    System.out.println(products);
    List<Output> output = products.stream().map(product -> new Output(
      product.getProduct_id(),
      product.getName(),
      product.getDescription(),
      product.getPrice_in_cents()
    )).toList();

    return output;
  }
}

record Output(
  String product_id,
  String name,
  String description,
  int price_in_cents
){}
