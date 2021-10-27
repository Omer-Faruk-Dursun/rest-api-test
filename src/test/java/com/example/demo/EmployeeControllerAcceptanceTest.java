package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.springframework.http.HttpStatus.OK;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerAcceptanceTest {

    @LocalServerPort
    int randomServerPort;

    private RestTemplate restTemplate;
    private String url;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
        url = "http://localhost:" + randomServerPort + "/employees/1";
    }

    @Test
    void one() {
        ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals("{\"id\":1,\"name\":\"Bilbo Baggins\",\"role\":\"burglar\"}", responseEntity.getBody());
    }
}