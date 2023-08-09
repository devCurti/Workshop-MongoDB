package com.devCurti.WorkshopMongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devCurti.WorkshopMongoDB.entities.Post;

/*Criando repositório*/
public interface PostRepository extends MongoRepository<Post, String> {

}
