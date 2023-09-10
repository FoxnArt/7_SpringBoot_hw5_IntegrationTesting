package ru.netology._7_springboot_hw1_conditional_application;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final GenericContainer<?> devapp1 = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    private static final GenericContainer<?> prodapp1 = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        devapp1.start();
        prodapp1.start();
    }

    @Test
    public void contextLoads() {
        ResponseEntity<String> forEntityDevapp = restTemplate.getForEntity("http://localhost:" + devapp1.getMappedPort(8080) + "/profile", String.class);
        System.out.println(forEntityDevapp.getBody());
        ResponseEntity<String> forEntityProdapp = restTemplate.getForEntity("http://localhost:" + prodapp1.getMappedPort(8081) + "/profile", String.class);
        System.out.println(forEntityProdapp.getBody());
        assertEquals("Current profile is dev", forEntityDevapp.getBody());
        assertEquals("Current profile is production", forEntityProdapp.getBody());
    }
}