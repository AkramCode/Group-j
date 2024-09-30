package com.groupjagriapp.service;
import com.groupjagriapp.model.Product;
import com.groupjagriapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
@Autowired
private ProductRepository productRepository;
public List<Product> getAllProducts() {
return productRepository.findAll();
}
public Product addProduct(Product product) {
return productRepository.save(product);
}
public Product updateProduct(Long id, Product productDetails) {
return productRepository.findById(id)
.map(product -> {
product.setName(productDetails.getName());
product.setPrice(productDetails.getPrice());
product.setQuantity(productDetails.getQuantity());
return productRepository.save(product);
}).orElse(null);
}
public void deleteProduct(Long id) {
productRepository.deleteById(id);
}
}