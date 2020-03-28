package com.project.c2cbooking;

import com.project.c2cbooking.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)

public class C2cbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(C2cbookingApplication.class, args);
	}

}
