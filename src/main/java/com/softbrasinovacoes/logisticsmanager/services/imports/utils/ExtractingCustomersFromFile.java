package com.softbrasinovacoes.logisticsmanager.services.imports.utils;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.softbrasinovacoes.logisticsmanager.domain.customers.Customer;

public class ExtractingCustomersFromFile {
  public static List<Customer> run(Document doc) {
    NodeList clients = doc.getElementsByTagName("dest");
    List<Customer> customers = new ArrayList<Customer>();

    for (int i = 0; i < clients.getLength(); i++) {
      Element element = (Element) clients.item(i);
      String name = element.getElementsByTagName("xNome").item(0).getTextContent();
      String email = element.getElementsByTagName("email").item(0).getTextContent();
      String phone = element.getElementsByTagName("fone").item(0).getTextContent();
      String cnpj = element.getElementsByTagName("CNPJ").item(0).getTextContent();

      String street = element.getElementsByTagName("xLgr").item(0).getTextContent();
      String number = element.getElementsByTagName("nro").item(0).getTextContent();
      String neighborhood = element.getElementsByTagName("xBairro").item(0).getTextContent();
      String city = element.getElementsByTagName("xMun").item(0).getTextContent();
      String state = element.getElementsByTagName("UF").item(0).getTextContent();
      String country = element.getElementsByTagName("xPais").item(0).getTextContent();

      String address = String.format(
          "%s, %s, %s | %s - %s %s",
          street, number, neighborhood, city, state, country
      ).toLowerCase();

      Customer createdCustomer = new Customer(name, email, phone, address, cnpj);
      customers.add(createdCustomer);
    }

    return customers;
  }
}
