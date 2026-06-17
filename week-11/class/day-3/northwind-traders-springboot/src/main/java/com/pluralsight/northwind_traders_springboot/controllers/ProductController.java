package com.pluralsight.northwind_traders_springboot.controllers;

import com.pluralsight.northwind_traders_springboot.models.Product;
import com.pluralsight.northwind_traders_springboot.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ResponseEntity<Product>> getProductById(@PathVariable Long id) {
        return productService.getProductsById(id).map(ResponseEntity::ok);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

}
