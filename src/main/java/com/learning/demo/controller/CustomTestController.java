package com.learning.demo.controller;

import com.learning.demo.service.HelloService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class CustomTestController {

    @Autowired
    HelloService helloService;
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "Aarohi") String name) {
        return helloService.getHello(name);
    }

}
