package com.example.sportsbetting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @ComponentScan({"com.example.sportsbetting.database.service"})
// @EntityScan("com.example.sportsbetting.database.model")
// @EnableJpaRepositories("com.example.sportsbetting.database.repository")
public class SportsbettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsbettingApplication.class, args);
	}

}
