package com.hashinclude.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DummyController {

    public DummyController() {
        System.out.println("Hello DummyController");
    }

    @GetMapping("/get")
    public String demo() {
        return "Dummy";
    }
}
