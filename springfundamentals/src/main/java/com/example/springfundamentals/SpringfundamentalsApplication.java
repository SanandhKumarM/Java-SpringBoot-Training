package com.example.springfundamentals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication // @ annotation calls the classes and functions
public class SpringfundamentalsApplication implements CommandLineRunner{

	@Autowired // These @ things are called beans in spring boot
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringfundamentalsApplication.class, args);
	}

	@Override
	public void run(String... args){  // ... is called the spread operator

		// Create a Record
		User user = new User("Sanandh", "Kumar");
		userRepository.saveAndFlush(user);	// Directly communicating with

		//Retrieve the record
		user = userRepository.findById(1).orElse(null);
		System.out.println(user);

		//Update a Record
		user.setLname("Kumar");
		System.out.println(user);

		//Remove a Record
		userRepository.delete(user);
	}

}
