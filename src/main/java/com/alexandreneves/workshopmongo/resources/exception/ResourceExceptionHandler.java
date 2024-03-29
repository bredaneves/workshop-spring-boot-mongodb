package com.alexandreneves.workshopmongo.resources.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alexandreneves.workshopmongo.services.exception.ObjectNotFoundException;

//diferente do Github, porém esse não funciona >> import javax.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequest;


//notação abaixo indica que essa classe é responsável por tratar possíveis exceções
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
