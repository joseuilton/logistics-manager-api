package com.softbrasinovacoes.logisticsmanager.services.products;

import java.util.List;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.products.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetAllProductsService {
  private final ProductRepository productRepository;

  public List<GetAllProductsOutput> execute() {
    var products = productRepository.findAll();
    List<GetAllProductsOutput> output = products.stream().map(product -> new GetAllProductsOutput(
      product.getProduct_id(),
      product.getName(),
      product.getDescription(),
      product.getPrice_in_cents(),
      product.getItens().stream().map(item -> new ItemData(item.getItem_id(), item.getEanCode())).toList()
    )).toList();

    return output;
  }
}

record ItemData(
  Long item_id,
  String ean_code
){}

record GetAllProductsOutput(
  String product_id,
  String name,
  String description,
  int price_in_cents,
  List<ItemData> itens
){}
