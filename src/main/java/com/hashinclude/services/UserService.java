package com.hashinclude.services;

import com.hashinclude.models.User;
import com.hashinclude.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Scope("prototype")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
        System.out.println("hello UserService");
    }

    public User getUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("No user found with id" + id);
        }
    }

    // This api helps to add new user
    // if user already exist then don't add it => Then return user already exist
    // if username is blank or null or empty throw the error => username should not be null
    // if id is < 0 then return id should not be less than zero.
    public String addUser(User user) {
        userRepository.save(user);
        return "User added Successfully";
    }

    public String updateUser(User user) {
        userRepository.save(user);
        return "Updated Successfully";
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "delete Successfully";
    }

}
