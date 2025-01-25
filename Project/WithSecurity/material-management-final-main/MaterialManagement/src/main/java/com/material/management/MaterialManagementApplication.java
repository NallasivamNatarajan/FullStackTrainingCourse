package com.material.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class MaterialManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaterialManagementApplication.class, args);
	}

}
