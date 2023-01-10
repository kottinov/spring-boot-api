package com.example.kottinov.placement;

import com.example.kottinov.customer.Customer;
import com.example.kottinov.product.Product;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name = "Placement")
@Table(name = "placement")
public class Placement {

  @Id
  @SequenceGenerator(
    name = "placement_sequence",
    sequenceName = "placement_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "placement_sequence"
  )
  private Long id;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  @ElementCollection(targetClass = Product.class)
  private List<Product> products;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  public Placement() {}

  public Placement(ArrayList<Product> arrayList, Customer customer1) {
    this.products = arrayList;
    this.customer = customer1;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> list) {
    this.products = list;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Long getCustomerId() {
    return customer.getId();
  }

  public String getCustomerEmail() {
    return customer.getEmail();
  }

  @Override
  public String toString() {
    return (
      "Placement{" +
      "id=" +
      id +
      ", products=" +
      products +
      ", customer=" +
      customer +
      '}'
    );
  }
}
