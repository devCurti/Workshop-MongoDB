package com.devCurti.WorkshopMongoDB.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devCurti.WorkshopMongoDB.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		User maria = new User("1", "Maria", "maria@gmail.com");
		User alex = new User("2", "Alex", "alex@gmail.com");
		List<User> result = new ArrayList<>();
		result.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(result);
	}
	
}
