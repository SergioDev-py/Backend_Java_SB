package com.microservice.product.Controller;


import com.microservice.product.Entities.Product;
import com.microservice.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    // Get all products
    @GetMapping()
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // Get one product by name
    @GetMapping("/{name}")
    public Product getProduct(@PathVariable String name) {
        return productRepo.findByName(name);
    }

    // Create one product
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    // Update product by name
    @PutMapping("/{name}")
    public Product updateProduct(@PathVariable String name, @RequestBody Product productDetails) {
        Product product = productRepo.findByName(name);

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());

        productRepo.save(product);

        return product;
    }

    // Delete a product by name
    @DeleteMapping("/{name}")
    public Product deleteProduct(@PathVariable String name) {
        Product product = productRepo.findByName(name);
        productRepo.delete(product);
        return product;
    }

}
