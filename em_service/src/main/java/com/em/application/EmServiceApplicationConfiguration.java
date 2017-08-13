package com.em.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.em.services"})
@Import(EmRepositoryApplicationConfiguration.class)
public class EmServiceApplicationConfiguration {

}
