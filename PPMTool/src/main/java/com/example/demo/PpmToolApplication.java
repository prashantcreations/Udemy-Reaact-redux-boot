package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.services.MasterTableDataService;
@ComponentScan("com.example.demo")
@SpringBootApplication
@EnableScheduling
public class PpmToolApplication {

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	} 
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PpmToolApplication.class, args);
		MasterTableDataService masterTableDataService = context.getBean(MasterTableDataService.class);
	}

}
