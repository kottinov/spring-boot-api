package com.example.kottinov.customer;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/")
  public List<CustomerDTO> getCustomers() {
    return customerService
      .getCustomers()
      .stream()
      .map(this::convertToDTO)
      .collect(Collectors.toList());
  }

  private CustomerDTO convertToDTO(Customer customer) {
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setId(customer.getId());
    customerDTO.setFirstName(customer.getFirstName());
    customerDTO.setLastName(customer.getLastName());
    customerDTO.setEmail(customer.getEmail());
    customerDTO.setRole(customer.getRole());

    return customerDTO;
  }

  @PostMapping("/")
  public void addCustomer(@RequestBody Customer customer) {
    customerService.addCustomer(customer);
  }

  @DeleteMapping("/{customerId}")
  public void deleteCustomer(@PathVariable("customerId") Long customerId) {
    customerService.deleteCustomer(customerId);
  }

  @PutMapping("/{customerId}")
  public void updateCustomer(
    @PathVariable("customerId") Long customerId,
    @RequestBody Customer customer
  ) {
    customerService.updateCustomer(customerId, customer);
  }
}
