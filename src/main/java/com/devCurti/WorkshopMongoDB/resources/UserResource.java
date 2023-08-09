package com.devCurti.WorkshopMongoDB.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devCurti.WorkshopMongoDB.DTO.UserDTO;
import com.devCurti.WorkshopMongoDB.entities.User;
import com.devCurti.WorkshopMongoDB.services.UserService;

@RestController //Informando que essa classe é um Resource/Controller
@RequestMapping(value="/users") //Criando o endpoint
public class UserResource {
	
	@Autowired //Injeção de dependencia
	UserService userService;
	
	@GetMapping //Informando que toda vez que cair no endpoint será executado esse método
	//ResponseEntity é utilizado pois serve para tratamentos de erros.
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> result = new ArrayList<>();
		result = userService.getAll().stream().map(UserDTO::new).toList();
		return ResponseEntity.ok().body(result); //Já que o retorno é do tipo ResponseEntity
		//É necessário chamar esse método e colocar o resultado no body()
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable String id) {
		User result = new User();
		result = userService.getById(id);
		UserDTO user = new UserDTO(result);
		return ResponseEntity.ok().body(user);
	}
	
}
