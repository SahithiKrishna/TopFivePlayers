package com.intuit.gamedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.intuit.controller","com.intuit.service","com.intuit.dto"})
@EntityScan(basePackages = {"com.intuit.entity"})
@EnableJpaRepositories(basePackages = {"com.intuit.repository"})
@EnableCaching
public class GameDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameDataApplication.class, args);
	}

}
