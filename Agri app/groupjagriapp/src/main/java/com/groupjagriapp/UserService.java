package com.groupjagriapp.service;
import com.groupjagriapp.model.User;
import com.groupjagriapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
@Autowired
private UserRepository userRepository;
public User findByUsername(String username) {
return userRepository.findByUsername(username);
}
public void saveUser(User user) {
userRepository.save(user);
}
}