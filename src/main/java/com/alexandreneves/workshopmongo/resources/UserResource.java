package com.alexandreneves.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexandreneves.workshopmongo.domain.User;
import com.alexandreneves.workshopmongo.services.UserService;

//a notação abaixo indica que é um componente do tipo Rest Controller
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	//a notação abaixo também pode ser substituída por @GetMapping
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		/*User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex  = new User("1", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));*/
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
