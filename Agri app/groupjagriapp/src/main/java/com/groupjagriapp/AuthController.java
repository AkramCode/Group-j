package com.groupjagriapp.controller;
import com.groupjagriapp.model.User;
import com.groupjagriapp.security.JwtTokenProvider;
import com.groupjagriapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
@Autowired
private UserService userService;
@Autowired
private JwtTokenProvider jwtTokenProvider;
@Autowired
private PasswordEncoder passwordEncoder;
@PostMapping("/signup")
public ResponseEntity<String> signup(@Validated @RequestBody User user) {
user.setPassword(passwordEncoder.encode(user.getPassword()));
userService.saveUser(user);
return ResponseEntity.ok("User registered successfully!");
}
@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody User user) {
User foundUser = userService.findByUsername(user.getUsername());
if
(foundUser
!= null
&& passwordEncoder.matches(user.getPassword(),
foundUser.getPassword())) {
String token = jwtTokenProvider.generateToken(foundUser.getUsername());
return ResponseEntity.ok(token);
} else {
return ResponseEntity.status(401).body("Invalid credentials");
}
}
}