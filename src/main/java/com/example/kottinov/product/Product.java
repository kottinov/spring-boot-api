package com.example.kottinov.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Product {

  @Id
  @SequenceGenerator(
    name = "product_sequence",
    sequenceName = "product_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "product_sequence"
  )
  private Long id;

  private String name;
  private String description;
  private int price;

  public Product() {}

  public Product(Long id, String name, String description, int price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Product(String name, String description, int price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return (
      "Product [id=" +
      id +
      ", name=" +
      name +
      ", description=" +
      description +
      ", price=" +
      price +
      "]"
    );
  }
}
