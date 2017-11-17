package com.mock.empapi.empapimock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EmpapiMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpapiMockApplication.class, args);
    }
}
