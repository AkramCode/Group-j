package com.groupjagriapp.model;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long productID;
@NotBlank(message = "Product name is mandatory")
private String name;
@NotBlank(message = "Category is mandatory")
private String category;
@Min(value = 0, message = "Price must be positive")
private Double price;
@Min(value = 0, message = "Quantity must be positive")
private Integer quantity;
// Getters and Setters
public Long getProductID() {
return productID;
}
public void setProductID(Long productID) {
this.productID = productID;
}
public String getName() {
return name;
}
public void setName(String name) {
    this.name = name;
}
public String getCategory() {
return category;
}
public void setCategory(String category) {
this.category = category;
}
public Double getPrice() {
return price;
}
public void setPrice(Double price) {
this.price = price;
}
public Integer getQuantity() {
return quantity;
}
public void setQuantity(Integer quantity) {
this.quantity = quantity;
}
}