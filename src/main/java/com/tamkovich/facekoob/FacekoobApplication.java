package com.tamkovich.facekoob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FacekoobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacekoobApplication.class, args);
	}

}
