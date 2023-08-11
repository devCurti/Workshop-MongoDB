package com.devCurti.WorkshopMongoDB.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devCurti.WorkshopMongoDB.entities.Post;

import com.devCurti.WorkshopMongoDB.services.PostService;

@RestController // Informando que essa classe é um Resource/Controller
@RequestMapping(value = "/posts") // Criando o endpoint
public class PostResource {

	@Autowired // Injeção de dependencia
	PostService PostService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> getById(@PathVariable String id) {
		Post result = new Post();
		result = PostService.getById(id);
		Post Post = result;
		return ResponseEntity.ok().body(Post);
	}

}
