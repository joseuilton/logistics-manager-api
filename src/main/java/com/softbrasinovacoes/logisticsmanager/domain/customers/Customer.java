package com.softbrasinovacoes.logisticsmanager.domain.customers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "customer")
@Entity(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "customer_id")
public class Customer {
  @Id @GeneratedValue(strategy = GenerationType.UUID)
  private String customer_id;

  private String name;
  private String email;
  private String phone;
  private String address;
  private String cnpj;

  public Customer(
    String name,
    String email,
    String phone,
    String address,
    String cnpj
  ){
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.cnpj = cnpj;
  }
}
