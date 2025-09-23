package com.hashinclude.services;

import com.hashinclude.models.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    List<User> userList = new ArrayList<>(List.of(new User(1, "arun"), new User(2, "pavan")));

    public User getUser(int id) {
        System.out.println(id);
        Optional<User> user = userList.stream()
                .filter(usr -> usr.id == id)
                .findFirst();
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
        System.out.println(userList.size());
        userList.add(user);
        System.out.println(userList.size());
        return "User added Successfully";
    }

    public String updateUser(User user) {
        System.out.println("Before updating" + userList);
        User existingUser = userList.stream()
                .filter(usr -> usr.id == user.id)
                .findFirst().get();

        if (existingUser != null) {
            existingUser.name = user.name;
            userList.add(existingUser);
            System.out.println("After updating" + userList);
            return "User updated Successfully";

        } else {
            userList.add(existingUser);
            System.out.println("After updating" + userList);
            return "User added Successfully";
        }

    }

    public String deleteUser(int id) {
        Optional<User> user = userList.stream()
                .filter(usr -> usr.id == id)
                .findFirst();
        userList.remove(user);
        System.out.println(userList.size());
        return "delete Successfully";
    }

}
