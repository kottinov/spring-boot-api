package com.example.kottinov.placement;

import com.example.kottinov.customer.Customer;
import com.example.kottinov.product.Product;
import java.util.List;

public class PlacementDTO {

  private Long id;
  private Customer customer;
  private List<Product> products;

  public PlacementDTO() {}

  public PlacementDTO(
    Long id,
    Customer customer,
    List<Product> products
  ) {
    this.id = id;
    this.customer = customer;
    this.products = products;
  }

  public PlacementDTO(Customer customer, List<Product> products) {
    this.customer = customer;
    this.products = products;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer2) {
    this.customer = customer2;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> list) {
    this.products = list;
  }

  @Override
  public String toString() {
    return (
      "PlacementDTO [customer=" + customer + ", products=" + products + "]"
    );
  }
}
