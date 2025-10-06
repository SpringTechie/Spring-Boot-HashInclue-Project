package com.hashinclude;

import com.hashinclude.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootHashIncludeProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootHashIncludeProjectApplication.class, args);

		UserService service1 = (UserService) context.getBean("userService");
		System.out.println(service1.hashCode());

		UserService service2 =  context.getBean("userService", UserService.class);
		System.out.println(service2.hashCode());


	}

}
