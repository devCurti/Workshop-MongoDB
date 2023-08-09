package com.devCurti.WorkshopMongoDB.DTO;

import com.devCurti.WorkshopMongoDB.entities.User;

public record AuthorDTO(String id, String name) {
	
	public AuthorDTO(User user) {
		this(user.getId(), user.getName());
	}
	
}
