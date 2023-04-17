package com.dm.OnlineBookStore.repository;

import com.dm.OnlineBookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}