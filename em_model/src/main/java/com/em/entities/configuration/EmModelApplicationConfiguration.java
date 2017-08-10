package com.em.entities.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan({"com.em.entities.models"})
@EnableAutoConfiguration
public class EmModelApplicationConfiguration {

}
