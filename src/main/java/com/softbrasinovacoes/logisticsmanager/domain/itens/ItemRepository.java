package com.softbrasinovacoes.logisticsmanager.domain.itens;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long> {
  Optional<Item> findByEanCode(String eanCode);
}
