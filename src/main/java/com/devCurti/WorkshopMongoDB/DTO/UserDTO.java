package com.devCurti.WorkshopMongoDB.DTO;

import com.devCurti.WorkshopMongoDB.entities.User;

public record UserDTO(String id, String name, String email) {
	
	
	public UserDTO(User user) {
		this(user.getId(), user.getName(), user.getEmail());
	}
}
