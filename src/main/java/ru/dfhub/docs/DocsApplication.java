package ru.dfhub.docs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocsApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DocsApplication.class);
		app.setLazyInitialization(true);
		app.run(args);
	}
}
