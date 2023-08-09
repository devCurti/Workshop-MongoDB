package com.devCurti.WorkshopMongoDB.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devCurti.WorkshopMongoDB.entities.User;
import com.devCurti.WorkshopMongoDB.repositories.UserRepository;


@Configuration //Informando ao Spring que esse arquivo é uma configuração
public class Instantiation implements CommandLineRunner{ 
	//CommandLineRunner significa que toda vez que o programa entrar em RunTime será 
	//executado o método run
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
	}

}
