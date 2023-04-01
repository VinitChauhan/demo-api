package com.learning.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomTestControllerAcceptanceTest {
    private RestTemplate restTemplate;
    private String url;
    @LocalServerPort
    private int randomServerPort;
    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
        url = "http://localhost:" + randomServerPort + "/test/hello";
    }
    @Test
    void sayHelloWithDefaultName() throws Exception {
        ResponseEntity response = restTemplate.getForEntity(url, String.class);
        assertEquals(OK, response.getStatusCode());
        assertEquals("Hello Aarohi", response.getBody());

    }
    @Test
    void sayHelloWithRequestParamName() throws Exception {
        ResponseEntity response = restTemplate.getForEntity(url + "?name=Vinit", String.class);
        assertEquals(OK, response.getStatusCode());
        assertEquals("Hello Vinit", response.getBody());
    }
}
