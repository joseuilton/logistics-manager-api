package com.softbrasinovacoes.logisticsmanager.services.itens;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.itens.Item;
import com.softbrasinovacoes.logisticsmanager.domain.itens.ItemRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteItemService {
  private final ItemRepository itemRepository;

  public void execute(Long id) {
    Optional<Item> optionalItem = itemRepository.findById(id);

    if (optionalItem.isEmpty()) {
      throw new EntityNotFoundException("Item not found");
    }

    itemRepository.delete(optionalItem.get());
  }
}
