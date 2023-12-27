package com.example.signupservice;

import com.example.signupservice.Model.User;
import com.example.signupservice.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SignupserviceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SignupserviceApplication.class, args);
	}

	private final UserRepository userRepository;
	public SignupserviceApplication(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception{
		userRepository.save(new User("Sanandh","sanandh.m@nineleaps.com","1234"));
		userRepository.save(new User("Ayush","ayush.m@nineleaps.com","5678"));
		userRepository.save(new User("Parth","parth.m@nineleaps.com","910111"));

		userRepository.findAll().forEach(System.out::println);

	}
}
