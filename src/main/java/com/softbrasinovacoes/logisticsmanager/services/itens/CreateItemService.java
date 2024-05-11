package com.softbrasinovacoes.logisticsmanager.services.itens;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.itens.Item;
import com.softbrasinovacoes.logisticsmanager.domain.itens.ItemRepository;
import com.softbrasinovacoes.logisticsmanager.domain.products.Product;
import com.softbrasinovacoes.logisticsmanager.domain.products.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateItemService {
  private final ItemRepository itemRepositiry;
  private final ProductRepository productRepository;

  public CreateItemOutput execute(String product_id, String cnpj) {
    Optional<Product> optionalProduct = productRepository.findById(product_id);

    if (optionalProduct.isEmpty()) {
      throw new EntityNotFoundException("Product not found");
    }

    var item = new Item(optionalProduct.get());
    itemRepositiry.save(item);
    String ean_code = String.format(
      "789%s%05d",
      cnpj.substring(0, 5),
      item.getItem_id()
    );

    item.setEanCode(ean_code);
    return new CreateItemOutput(
      item.getItem_id(),
      item.getEanCode(),
      new ProductData(
        item.getProduct().getProduct_id(),
        item.getProduct().getName(),
        item.getProduct().getDescription(),
        item.getProduct().getPrice_in_cents()
    ));
  }
}
record ProductData(
  String product_id,
  String name,
  String description,
  int price_in_cents
){}

record CreateItemOutput(
  Long item_id,
  String ean_code,
  ProductData product
){}
