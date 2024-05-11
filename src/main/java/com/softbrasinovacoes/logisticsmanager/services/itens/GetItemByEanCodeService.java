package com.softbrasinovacoes.logisticsmanager.services.itens;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.itens.Item;
import com.softbrasinovacoes.logisticsmanager.domain.itens.ItemRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetItemByEanCodeService {
  private final ItemRepository itemRepository;

  public GetItemByEanCodeOutput execute(String ean_code) {
    Optional<Item> optionalItem = itemRepository.findByEanCode(ean_code);

    if (optionalItem.isEmpty()) {
      throw new EntityNotFoundException("Item not found");
    }

    var item = optionalItem.get();

    return new GetItemByEanCodeOutput(
      item.getItem_id(),
      item.getEanCode(),
      new GetItemByEanCodeProductData(
        item.getProduct().getProduct_id(),
        item.getProduct().getName(),
        item.getProduct().getDescription(),
        item.getProduct().getPrice_in_cents()
      )
    );
  }
}

record GetItemByEanCodeProductData(
  String product_id,
  String name,
  String description,
  int price_in_cents
){}

record GetItemByEanCodeOutput(
  Long item_id,
  String ean_code,
  GetItemByEanCodeProductData product
){}
