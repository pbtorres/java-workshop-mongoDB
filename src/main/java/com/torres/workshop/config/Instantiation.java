package com.torres.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.torres.workshop.domain.User;
import com.torres.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria", "maria@gmail.com");
		User paulo = new User(null, "Paulo", "paulo@gmail.com");
		User joao = new User(null, "João", "joao@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, paulo, joao));
		
	}

}
