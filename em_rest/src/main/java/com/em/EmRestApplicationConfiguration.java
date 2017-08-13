package com.em;

import com.em.application.EmRepositoryApplicationConfiguration;
import com.em.application.EmServiceApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.em.controllers", "com.em.init.data"})
@Import(EmServiceApplicationConfiguration.class)
@ImportResource("classpath:/spring/em-rest-context.xml")
public class EmRestApplicationConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(EmRestApplicationConfiguration.class, args);
	}
}
