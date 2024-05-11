package com.softbrasinovacoes.logisticsmanager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softbrasinovacoes.logisticsmanager.controllers.dtos.InputCreateItemDTO;
import com.softbrasinovacoes.logisticsmanager.controllers.dtos.InputCreateProductDTO;
import com.softbrasinovacoes.logisticsmanager.controllers.dtos.InputUpdateProductDTO;
import com.softbrasinovacoes.logisticsmanager.services.customers.DeleteCustomerService;
import com.softbrasinovacoes.logisticsmanager.services.customers.GetAllCustomersService;
import com.softbrasinovacoes.logisticsmanager.services.customers.GetCustomerService;
import com.softbrasinovacoes.logisticsmanager.services.itens.CreateItemService;
import com.softbrasinovacoes.logisticsmanager.services.products.CreateProductService;
import com.softbrasinovacoes.logisticsmanager.services.products.DeleteProductService;
import com.softbrasinovacoes.logisticsmanager.services.products.GetAllProductsService;
import com.softbrasinovacoes.logisticsmanager.services.products.GetProductService;
import com.softbrasinovacoes.logisticsmanager.services.products.UpdateProductService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductsController {
  private final GetAllProductsService getAllProductsService;
  private final GetProductService getProductService;
  private final CreateProductService createProductService;
  private final UpdateProductService updateProductService;
  private final DeleteProductService deleteProductService;
  private final CreateItemService createItemService;

  @GetMapping
  public ResponseEntity getAllProducts() {
    var products = getAllProductsService.execute();
    return ResponseEntity.ok(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity getProduct(@PathVariable String id) {
    var customer = getProductService.execute(id);
    return ResponseEntity.ok(customer);
  }

  @PostMapping
  public ResponseEntity createProduct(@RequestBody @Valid InputCreateProductDTO data) {
    var product = createProductService.execute(
        data.name(),
        data.description(),
        data.price_in_cents()
    );
    return ResponseEntity.created(null).body(product);
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity updateProduct(
      @PathVariable String id,
      @RequestBody @Valid InputUpdateProductDTO data
  ) {
    var product = updateProductService.execute(
        id,
        data.name(),
        data.description(),
        data.price_in_cents()
    );
    return ResponseEntity.ok(product);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteProduct(@PathVariable String id) {
    deleteProductService.execute(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/{id}/itens")
  @Transactional
  public ResponseEntity createItem(
    @PathVariable String id,
    @RequestBody @Valid InputCreateItemDTO data
  ) {
    var item = createItemService.execute(id, data.cnpj());
      
    return ResponseEntity.created(null).body(item);
  }
  
}
