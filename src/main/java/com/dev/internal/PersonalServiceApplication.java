package com.dev.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PersonalServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PersonalServiceApplication.class, args);
	}
}
