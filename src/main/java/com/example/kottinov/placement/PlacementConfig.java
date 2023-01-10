package com.example.kottinov.placement;

import com.example.kottinov.customer.Customer;
import com.example.kottinov.customer.CustomerRepository;
import com.example.kottinov.customer.Role;
import com.example.kottinov.product.Product;
import com.example.kottinov.product.ProductRepository;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlacementConfig {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Bean
  CommandLineRunner placementLineRunner(PlacementRepository repository) {
    Customer customer1 = new Customer(
      "John",
      "Doe",
      "johndoe@gmail.com",
      Role.USER
    );
    Customer customer2 = new Customer(
      "Alexandru",
      "Constantinov",
      "kottinov@gmail.com",
      Role.ADMIN
    );

    customerRepository.save(customer1);
    customerRepository.save(customer2);

    Product margherita = new Product(
      "Margherita",
      "Tomato sauce, mozzarella, basil",
      5
    );

    Product pepperoni = new Product(
      "Pepperoni",
      "Tomato sauce, mozzarella, pepperoni",
      6
    );

    Product hawaiian = new Product(
      "Hawaiian",
      "Tomato sauce, mozzarella, ham, pineapple",
      7
    );

    productRepository.save(margherita);
    productRepository.save(pepperoni);
    productRepository.save(hawaiian);

    return args -> {
      Placement placement1 = new Placement(
        new ArrayList<Product>(Arrays.asList(margherita, pepperoni)),
        customer1
      );
      Placement placement3 = new Placement(
        new ArrayList<Product>(Arrays.asList(hawaiian, margherita)),
        customer2
      );

      repository.save(placement1);
      repository.save(placement3);
    };
  }
}
