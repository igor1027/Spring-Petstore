package com.example.spring_boot_rest.dao;

import com.example.spring_boot_rest.entity.User;

import java.util.Optional;

public interface UserDao {
    void save(User user);
    void delete(User user);
    Optional<User> getById(long id);
    Optional<User> getByUsername(String username);
    void update(String username, User user);
}
