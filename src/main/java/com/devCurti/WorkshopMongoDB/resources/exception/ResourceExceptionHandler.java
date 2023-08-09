package com.devCurti.WorkshopMongoDB.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devCurti.WorkshopMongoDB.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
//Informando que essa classe é responsável por tratar possíveis
//Erros nas requisições
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError str = new StandardError(System.currentTimeMillis(), status.value(), "Not found!", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(str);
	}
}
