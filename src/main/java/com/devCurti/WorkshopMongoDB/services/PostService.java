package com.devCurti.WorkshopMongoDB.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devCurti.WorkshopMongoDB.entities.Post;
import com.devCurti.WorkshopMongoDB.repositories.PostRepository;
import com.devCurti.WorkshopMongoDB.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	PostRepository repository;

	public Post getById(String id) {
		Post result = new Post();
		try {
			result = repository.findById(id).get();
		}
		catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Id not found!");
		}
		return result;
	}
}
