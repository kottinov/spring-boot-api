package com.example.kottinov.product;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  public void addProduct(Product product) {
    Optional<Product> productOptional = productRepository.findProductByName(
      product.getName()
    );
    if (productOptional.isPresent()) {
      throw new IllegalStateException("Product already exists");
    }
    productRepository.save(product);
  }

  public void deleteProduct(Long productId) {
    boolean exists = productRepository.existsById(productId);
    if (!exists) {
      throw new IllegalStateException(
        "Product with id " + productId + " does not exist"
      );
    }
    productRepository.deleteById(productId);
  }

  @Transactional
  public void updateProduct(Long productId, Product product) {
    Product productToUpdate = productRepository
      .findById(productId)
      .orElseThrow(() ->
        new IllegalStateException(
          "Product with id " + productId + " does not exist"
        )
      );
    if (
      product.getName() != null &&
      product.getName().length() > 0 &&
      !product.getName().equals(productToUpdate.getName())
    ) {
      Optional<Product> productOptional = productRepository.findProductByName(
        product.getName()
      );
      if (productOptional.isPresent()) {
        throw new IllegalStateException("Product already exists");
      }
      productToUpdate.setName(product.getName());
    }
    if (
      product.getDescription() != null &&
      product.getDescription().length() > 0 &&
      !product.getDescription().equals(productToUpdate.getDescription())
    ) {
      productToUpdate.setDescription(product.getDescription());
    }
    if (product.getPrice() > 0) {
      productToUpdate.setPrice(product.getPrice());
    }
  }
}
