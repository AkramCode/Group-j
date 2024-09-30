package com.groupjagriapp.controller;
import com.groupjagriapp.model.Product;
import com.groupjagriapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
@Autowired
private ProductService productService;
@GetMapping
public List<Product> getAllProducts() {
return productService.getAllProducts();
}
@PostMapping
public Product addProduct(@Valid @RequestBody Product product) {
return productService.addProduct(product);
}
@PutMapping("/{id}")
public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product
product) {
return productService.updateProduct(id, product);
}
@DeleteMapping("/{id}")
public void deleteProduct(@PathVariable Long id) {
productService.deleteProduct(id);
}
}