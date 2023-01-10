package com.example.kottinov.product;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

  @Bean
  CommandLineRunner productLineRunner(ProductRepository repository) {
    return args -> {
      Product carbonara = new Product(
        "Pizza Carbonara",
        "Carbonara pizza with bacon, mushrooms, and parmesan cheese",
        10
      );
      Product margherita = new Product(
        "Pizza Margherita",
        "Margherita pizza with tomatoes, mozzarella, and basil",
        8
      );

      repository.saveAll(List.of(carbonara, margherita));
    };
  }
}
