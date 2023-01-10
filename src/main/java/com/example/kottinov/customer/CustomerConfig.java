package com.example.kottinov.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

  @Bean
  CommandLineRunner customerLineRunner(CustomerRepository repository) {
    return args -> {
      Customer customer1 = new Customer(
        "John",
        "Doe",
        "johndoe@gmail.com",
        Role.USER
      );

      repository.save(customer1);
    };
  }
}
