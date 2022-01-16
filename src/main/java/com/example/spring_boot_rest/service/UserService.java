package com.example.spring_boot_rest.service;

import com.example.spring_boot_rest.entity.User;
import com.example.spring_boot_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public boolean save(User user){
        if(userRepository.existsByUsername(user.getUsername())){
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public User getByUsername(String username){
        Optional<User> user = userRepository.getByUsername(username);
        return user.orElse(null);
    }

    public boolean delete(String username){
        if (userRepository.existsByUsername(username)){
            User user = getByUsername(username);
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    public void update(String username, User user){
        if (userRepository.existsByUsername(username)){
            userRepository.save(user);
        }else{
            throw new RuntimeException("User with this username not found");
        }
    }

}
