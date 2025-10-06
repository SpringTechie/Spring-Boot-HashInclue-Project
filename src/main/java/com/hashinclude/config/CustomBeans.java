package com.hashinclude.config;

import com.hashinclude.services.ClassA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = {"dev","stage"})
public class CustomBeans {

    public CustomBeans() {
        System.out.println("Hello CustomBeans");
    }

    @Bean(name = "classAObject")
    public ClassA classA() {
        return new ClassA();
    }


}
