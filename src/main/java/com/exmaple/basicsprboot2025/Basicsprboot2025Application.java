package com.exmaple.basicsprboot2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Basicsprboot2025Application {
    public static void main(String[] args) {
        SpringApplication.run(Basicsprboot2025Application.class, args);
    }
}
