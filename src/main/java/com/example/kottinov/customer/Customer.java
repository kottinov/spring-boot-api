package com.example.kottinov.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Customer {

  @Id
  @SequenceGenerator(
    name = "customer_sequence",
    sequenceName = "customer_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "customer_sequence"
  )
  private Long id;

  @NotBlank(message = "First name is required")
  @Column(nullable = false, columnDefinition = "varchar(100)")
  private String firstName;

  @NotBlank(message = "Last name is required")
  @Column(nullable = false, columnDefinition = "varchar(100)")
  private String lastName;

  @NotBlank(message = "Email is required")
  @Column(nullable = false, columnDefinition = "varchar(100)")
  private String email;

  @NotBlank(message = "Password is required")
  @Column(nullable = false, columnDefinition = "varchar(100)")
  private String password;

  private Role role;

  public Customer() {}

  public Customer(
    Long id,
    String firstName,
    String lastName,
    String email,
    Role role
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.role = role;
  }

  public Customer(String firstName, String lastName, String email, Role role) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.role = role;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return (
      "Customer{" +
      "id=" +
      id +
      ", firstName='" +
      firstName +
      '\'' +
      ", lastName='" +
      lastName +
      '\'' +
      ", email='" +
      email +
      '\'' +
      '}'
    );
  }
}
