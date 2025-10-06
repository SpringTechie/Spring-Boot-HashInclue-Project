package com.hashinclude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DummyController {

    public DummyController() {
        System.out.println("Hello DummyController");
    }

    @GetMapping("/get")
    public String demo() {
        return "Dummy";
    }
}
