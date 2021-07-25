package ru.otus.microservicearchitecture.lesson6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class Lesson6Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson6Application.class, args);
	}

}
