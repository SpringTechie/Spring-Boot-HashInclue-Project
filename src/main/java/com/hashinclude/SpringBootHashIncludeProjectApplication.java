package com.hashinclude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequestMapping("/hash-include")
@RestController
public class SpringBootHashIncludeProjectApplication {
	List<User> userList = Arrays.asList(new User(1,"arun"),new User(2,"pavan"));

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHashIncludeProjectApplication.class, args);
	}
// http://localhost:8080/hash-include/user/id/1

	@GetMapping("/user/id/{id}")
	public User demoAPI(@PathVariable int id) {
		System.out.println(id);
		Optional<User> user = userList.stream()
				.filter(usr -> usr.id == id)
				.findFirst();
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new RuntimeException("No user found with id" + id);
		}

	}

}
