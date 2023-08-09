package com.devCurti.WorkshopMongoDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devCurti.WorkshopMongoDB.entities.User;
import com.devCurti.WorkshopMongoDB.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> getAll(){
		List<User> result = repository.findAll();
		return result;
	}
	
//	public User getId(String id){
//		User result = repository.findById(id).get();
//		return result;
//	}
}
