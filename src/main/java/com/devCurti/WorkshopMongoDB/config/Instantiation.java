package com.devCurti.WorkshopMongoDB.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devCurti.WorkshopMongoDB.DTO.AuthorDTO;
import com.devCurti.WorkshopMongoDB.DTO.CommentDTO;
import com.devCurti.WorkshopMongoDB.entities.Post;
import com.devCurti.WorkshopMongoDB.entities.User;
import com.devCurti.WorkshopMongoDB.repositories.PostRepository;
import com.devCurti.WorkshopMongoDB.repositories.UserRepository;


@Configuration //Informando ao Spring que esse arquivo é uma configuração
public class Instantiation implements CommandLineRunner{ 
	//CommandLineRunner significa que toda vez que o programa entrar em RunTime será 
	//executado o método run
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post p1 = new Post(null,  sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para SP abraços!", new AuthorDTO(maria));
		Post p2 = new Post(null,  sdf.parse("22/03/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("24/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("24/03/2018"), new AuthorDTO(bob));
		
		p1.getComments().addAll(Arrays.asList(c1,c2,c3));
			
		postRepository.saveAll(Arrays.asList(p1,p2));
		
		maria.getPosts().addAll(Arrays.asList(p1,p2));
		
		userRepository.save(maria);
		
		
		
	}

}
