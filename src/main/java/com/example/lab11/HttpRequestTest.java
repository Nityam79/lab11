package com.example.lab11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    @LocalServerPort
    private int port;
    private int doublenumber =6;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void DoubleNumber() throws Exception {



        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/double?number=" + doublenumber, String.class)).contains("12");


    }
}

