package com.devCurti.WorkshopMongoDB.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devCurti.WorkshopMongoDB.DTO.UserDTO;
import com.devCurti.WorkshopMongoDB.entities.User;
import com.devCurti.WorkshopMongoDB.repositories.UserRepository;
import com.devCurti.WorkshopMongoDB.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> getAll(){
		List<User> result = repository.findAll();
		return result;
	}
	

	public User getById(String id) {
		User result = new User();
		try {
			result = repository.findById(id).get();
		}
		catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Id not found!");
		}
		return result;
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	
	public void delete(String id) {
		getById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.id(), objDTO.name(), objDTO.email());
	}
}
