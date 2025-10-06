package com.hashinclude.config;

import com.hashinclude.services.ClassA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeans {

    public CustomBeans() {
        System.out.println("Hello CustomBeans");
    }

    @Bean(name = "classAObject")
    public ClassA classA() {
        return new ClassA();
    }


}
