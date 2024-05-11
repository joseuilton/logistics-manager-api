package com.softbrasinovacoes.logisticsmanager.services.imports;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;

import com.softbrasinovacoes.logisticsmanager.domain.customers.CustomerRepository;
import com.softbrasinovacoes.logisticsmanager.domain.itens.ItemRepository;
import com.softbrasinovacoes.logisticsmanager.domain.products.ProductRepository;
import com.softbrasinovacoes.logisticsmanager.services.imports.utils.ExtractingCustomersFromFile;
import com.softbrasinovacoes.logisticsmanager.services.imports.utils.ExtractingProductsAndItens;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

@Service
@AllArgsConstructor
public class ImportXmlNfeService {
  private final CustomerRepository customerRepository;
  private final ProductRepository productRepository;
  private final ItemRepository itemRepository;

  public void execute(MultipartFile file) {
    try {
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(file.getInputStream());

      doc.getDocumentElement().normalize();

      var customers = ExtractingCustomersFromFile.run(doc);
      var productsAndItens = ExtractingProductsAndItens.run(doc);
      var products = productsAndItens.getProducts();
      var itens = productsAndItens.getItens();

      customerRepository.saveAll(customers);
      productRepository.saveAll(products);
      itemRepository.saveAll(itens);

    } catch (Exception e) {
      throw new RuntimeException("Erro ao ler arquivo XML");
    }

  }
}
