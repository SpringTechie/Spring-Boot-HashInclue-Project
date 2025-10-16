package com.hashinclude.services;

import com.hashinclude.exceptions.UserNotFoundException;
import com.hashinclude.models.User;
import com.hashinclude.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Scope("prototype")
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
        System.out.println("hello UserService");
    }

    @Cacheable(key = "#id",value = "usertable")
    public User getUser(int id) {
        log.info("data not found in cache of id = {}",id);

        if(id<0) {
            log.warn("Id should not be negative");
            id = Math.abs(id);
        }
        Optional<User> user = userRepository.findById(id);
        try {
            if (user.isPresent()) {
                log.info("Use found with id {}",id);
                return user.get();
            }
            else {
                throw new UserNotFoundException("No user found with id "+id, 204);
            }
        }
        catch (UserNotFoundException exception) {
            log.error("Exception : " + exception.getMessage());
            throw exception;
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

    @CachePut(key = "#user.id",value = "usertable")
    public User updateUser(User user) {
       return userRepository.save(user);

    }

    @CacheEvict(key = "#id",value = "usertable")
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "delete Successfully";
    }

}
