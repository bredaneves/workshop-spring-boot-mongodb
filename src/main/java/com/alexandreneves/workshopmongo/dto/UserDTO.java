package com.alexandreneves.workshopmongo.dto;

import java.io.Serializable;

import com.alexandreneves.workshopmongo.domain.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {		
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
}
