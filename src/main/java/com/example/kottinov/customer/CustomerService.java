package com.example.kottinov.customer;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  public void addCustomer(Customer customer) {
    Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(
      customer.getEmail()
    );
    if (customerOptional.isPresent()) {
      throw new IllegalStateException("Email taken");
    }
    customerRepository.save(customer);
  }

  public void deleteCustomer(Long customerId) {
    boolean exists = customerRepository.existsById(customerId);
    if (!exists) {
      throw new IllegalStateException(
        "Customer with id " + customerId + " does not exists"
      );
    }
    customerRepository.deleteById(customerId);
  }

  public void updateCustomer(Long customerId, Customer customer) {
    Customer customer1 = customerRepository
      .findById(customerId)
      .orElseThrow(() ->
        new IllegalStateException(
          "Customer with id " + customerId + " does not exists"
        )
      );
    if (
      customer.getEmail() != null &&
      customer.getEmail().length() > 0 &&
      !customer.getEmail().equals(customer1.getEmail())
    ) {
      Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(
        customer.getEmail()
      );
      if (customerOptional.isPresent()) {
        throw new IllegalStateException("Email taken");
      }
      customer1.setEmail(customer.getEmail());
    }
    if (
      customer.getFirstName() != null &&
      customer.getFirstName().length() > 0 &&
      !customer.getFirstName().equals(customer1.getFirstName())
    ) {
      customer1.setFirstName(customer.getFirstName());
    }
    if (
      customer.getLastName() != null &&
      customer.getLastName().length() > 0 &&
      !customer.getLastName().equals(customer1.getLastName())
    ) {
      customer1.setLastName(customer.getLastName());
    }
    customerRepository.save(customer1);
  }
}
