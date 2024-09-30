package com.groupjagriapp.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotBlank(message = "Username is mandatory")
private String username;
@NotBlank(message = "Password is mandatory")
private String password;
@NotBlank(message = "Role is mandatory")
private String role; // 'Admin', 'Seller', 'Buyer'
// Getters and Setters
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public String getRole() {
return role;
}
public void setRole(String role) {
this.role = role;
}
}