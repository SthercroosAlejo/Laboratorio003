package com.example.demo.services;

import org.springframework.stereotype.Service;
import com.example.demo.models.User;
import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByUsernameAndPassword(String username, String password);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}

