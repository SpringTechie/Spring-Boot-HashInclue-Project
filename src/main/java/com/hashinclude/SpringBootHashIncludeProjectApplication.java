package com.hashinclude;

import com.hashinclude.services.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
				title = "HashInclude",
				version = "1.0.9",
				description = "My application APIS"
		)
)
public class SpringBootHashIncludeProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootHashIncludeProjectApplication.class, args);

		UserService service1 = (UserService) context.getBean("userService");
		System.out.println(service1.hashCode());

		UserService service2 =  context.getBean("userService", UserService.class);
		System.out.println(service2.hashCode());


	}

}
