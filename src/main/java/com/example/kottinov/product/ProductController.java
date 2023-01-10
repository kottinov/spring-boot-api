package com.example.kottinov.product;

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
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/")
  public List<ProductDTO> getProducts() {
    return productService
      .getProducts()
      .stream()
      .map(this::convertToDTO)
      .collect(Collectors.toList());
  }

  private ProductDTO convertToDTO(Product product) {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setId(product.getId());
    productDTO.setName(product.getName());
    productDTO.setPrice(product.getPrice());

    return productDTO;
  }

  @PostMapping("/")
  public void addProduct(@RequestBody Product product) {
    productService.addProduct(product);
  }

  @DeleteMapping("/{productId}")
  public void deleteProduct(@PathVariable("productId") Long productId) {
    productService.deleteProduct(productId);
  }

  @PutMapping("/{productId}")
  public void updateProduct(
    @PathVariable("productId") Long productId,
    @RequestBody Product product
  ) {
    productService.updateProduct(productId, product);
  }
}
