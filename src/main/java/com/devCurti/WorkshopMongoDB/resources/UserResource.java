package com.devCurti.WorkshopMongoDB.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devCurti.WorkshopMongoDB.DTO.UserDTO;
import com.devCurti.WorkshopMongoDB.entities.Post;
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
	
	@PostMapping
	//Informando que esse método é um método POST
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
		//RequestBody significa que o parametro a ser passado é necessário um Body
		User obj = userService.fromDTO(objDTO); //Transformando um DTO em um User
		obj = userService.insert(obj); //Inserindo no banco de dados o User
		//Informando a uri do documento criado.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id){
		User user = userService.fromDTO(userDTO);
		user.setId(id);
		userService.update(user);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping (value = "/{id}/posts") //Informando que toda vez que cair no endpoint será executado esse método
	//ResponseEntity é utilizado pois serve para tratamentos de erros.
	public ResponseEntity<List<Post>> getAllPosts(@PathVariable String id) {
		User obj = userService.getById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
	
}
