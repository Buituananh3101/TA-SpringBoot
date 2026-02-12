package com.example.s0705;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/a/b")
    public String sayHello2() {
        return "Hello World 2";
    }
}
