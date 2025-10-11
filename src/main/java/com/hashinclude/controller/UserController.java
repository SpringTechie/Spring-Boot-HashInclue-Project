package com.hashinclude.controller;

import com.hashinclude.models.User;
import com.hashinclude.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hash-include")
public class UserController {

    @Value("${spring.datasource.username}")
    private String  username;

    public UserController() {
        System.out.println("Hello UserController");
    }

    @Autowired
    private UserService userService;

    // to create user
    @GetMapping("/user/id/{id}")
    public User fetchUser(@PathVariable int id) {
        System.out.println("inside a method = "+username);
       return userService.getUser(id);
    }

    // to create new user
    @PostMapping("/new-user")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // To update user
    @PutMapping("/update-user")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "Updated Succefully";

    }

    // To delete any user from List
    @DeleteMapping("/delete-user/id/{id}")
    public String deleteUser(@PathVariable int id) {
       return userService.deleteUser(id);
    }

}
