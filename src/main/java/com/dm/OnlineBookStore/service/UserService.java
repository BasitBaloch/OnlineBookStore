package com.dm.OnlineBookStore.service;

import com.dm.OnlineBookStore.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(User user);
    String authenticateUser(String username, String password);
    User getCurrentUser();
}