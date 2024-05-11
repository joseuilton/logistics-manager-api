package com.softbrasinovacoes.logisticsmanager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softbrasinovacoes.logisticsmanager.services.itens.DeleteItemService;
import com.softbrasinovacoes.logisticsmanager.services.itens.GetItemByEanCodeService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/itens")
@AllArgsConstructor
public class ItensController {
  private final GetItemByEanCodeService getItemByEanCodeService;
  private final DeleteItemService deleteItemService;

  @GetMapping("/{ean_code}")
  public ResponseEntity getItemByEanCode(@PathVariable String ean_code) {
    var item = getItemByEanCodeService.execute(ean_code);
    return ResponseEntity.ok(item);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteItem(@PathVariable Long id) {
    deleteItemService.execute(id);
    return ResponseEntity.ok().build();
  }
  
}
