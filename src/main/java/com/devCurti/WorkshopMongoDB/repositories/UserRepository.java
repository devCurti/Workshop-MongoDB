package com.devCurti.WorkshopMongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository; 

import com.devCurti.WorkshopMongoDB.entities.User;

/*Criando repositório*/
public interface UserRepository extends MongoRepository<User, String> {

}
