package com.training.springbasics.HelloWorld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {
    @GetMapping("/world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping()
    public String hello(@RequestParam("name") String name) {
        return "Hello "+name;
    }
    @GetMapping("/name")
    public String name(@RequestParam("name") String name) {
        return name;
    }
}
