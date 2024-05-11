package com.softbrasinovacoes.logisticsmanager.services.imports.utils;

import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.softbrasinovacoes.logisticsmanager.domain.itens.Item;
import com.softbrasinovacoes.logisticsmanager.domain.products.Product;

import java.util.List;
import java.util.ArrayList;

public class ExtractingProductsAndItens {
  public static ProductsAndItensColletion run(Document doc) {
    NodeList productsNodeList = doc.getElementsByTagName("prod");
    List<Product> products = new ArrayList<Product>();
    List<Item> itens = new ArrayList<Item>();

    for (int i = 0; i < productsNodeList.getLength(); i++) {
      Element element = (Element) productsNodeList.item(i);
      String name = element
        .getElementsByTagName("xProd")
        .item(0)
        .getTextContent()
        .toLowerCase();
      String eanCode = element
        .getElementsByTagName("cEAN")
        .item(0)
        .getTextContent()
        .toLowerCase();
      double price = Double.parseDouble(
        element
          .getElementsByTagName("vProd")
          .item(0)
          .getTextContent()
      );

      Product createdProduct = new Product(
        name, 
        "No description",
       (int) price * 100
      );
      Item createdItem = new Item(eanCode, createdProduct);

      products.add(createdProduct);
      itens.add(createdItem);
    }

    return new ProductsAndItensColletion(products, itens);
  }
}
