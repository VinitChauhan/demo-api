package com.learning.demo.controller;

import com.learning.demo.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CustomTestControllerUnitTest {
    CustomTestController testController;

    @BeforeEach
    void init() {
        HelloService helloService = Mockito.mock(HelloService.class);
        when(helloService.getHello("Vinit")).thenReturn("Hello Vinit");
        testController = new CustomTestController(helloService);
    }

    @Test
    void sayHello() {
        assertEquals("Hello Vinit", testController.sayHello("Vinit"));
    }
}