package com.wildcodeschool.oqsecuritychallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wildcodeschool.oqsecuritychallenge.repository.UserRepository;
import com.wildcodeschool.oqsecuritychallenge.service.Generator;

@SpringBootApplication
public class OqsecuritychallengeApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Generator generatorService;

	public static void main(String[] args) {
		SpringApplication.run(OqsecuritychallengeApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (String[] args) -> {
			generatorService.generateRoles();
			generatorService.generateUserList();
		};
	}

}
