package com.em;

import com.em.application.EmRepositoryApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.em.controllers"})
@Import(EmRepositoryApplicationConfiguration.class)
public class EmRestApplicationConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(EmRestApplicationConfiguration.class, args);
	}
}
