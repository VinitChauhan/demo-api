package com.learning.demo.controller;

import com.learning.demo.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomTestController.class)
class CustomTestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    HelloService helloService;

    @Test
    void sayHelloWithDefaultName() throws Exception {
        when(helloService.getHello("Aarohi")).thenReturn("Hello Aarohi");
        mvc.perform(get("/test/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Aarohi")));
    }

    @Test
    void sayHelloWithRequestParamName() throws Exception {
        when(helloService.getHello("Vinit")).thenReturn("Hello Vinit");
        mvc.perform(get("/test/hello?name=Vinit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Vinit")));
    }
}