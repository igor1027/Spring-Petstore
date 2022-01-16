package com.example.spring_boot_rest.controller;

import com.example.spring_boot_rest.entity.User;
import com.example.spring_boot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody User user){
        if(userService.save(user)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable String username){
        if (userService.delete(username)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{username}")
    public void update(@PathVariable String username,@RequestBody User user){
        userService.update(username, user);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        User byUsername = userService.getByUsername(username);
        if(byUsername == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/createWithList")
    private ResponseEntity<?> createWithList(@RequestBody List<User> users){
        for (User user : users){
            if(!userService.save(user)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private ResponseEntity<?> createWithArray(@RequestBody User[] users){
        for (User user : users){
            if(!userService.save(user)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
