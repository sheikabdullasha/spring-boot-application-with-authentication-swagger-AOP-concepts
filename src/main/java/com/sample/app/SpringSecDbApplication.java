package com.sample.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScans({@ComponentScan("com.sample.app.configuration"),@ComponentScan("com.sample.app.controller"),@ComponentScan("com.sample.demo.logging")})
@EnableJpaRepositories("com.sample.app.repo")
@EntityScan("com.sample.app.entity")
public class SpringSecDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecDbApplication.class, args);
	}

}
