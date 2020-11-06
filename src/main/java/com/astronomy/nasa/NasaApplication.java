package com.astronomy.nasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasaApplication.class, args);
	}

}
