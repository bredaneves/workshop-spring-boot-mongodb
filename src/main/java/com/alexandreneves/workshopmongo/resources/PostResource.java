package com.alexandreneves.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alexandreneves.workshopmongo.domain.Post;
import com.alexandreneves.workshopmongo.resources.util.URL;
import com.alexandreneves.workshopmongo.services.PostService;

//a notação abaixo indica que é um componente do tipo Rest Controller
@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);
	}	
	
	//o método abaixo irá receber o parâmetro text na chamada url de forma codificada
	//será preciso decodificar antes de usar para fazer a busca
	@RequestMapping(value="/titlesearch",method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);			
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/titlesearch1",method=RequestMethod.GET)
	public ResponseEntity<List<Post>> searchTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.searchTitle(text);			
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/fullsearch",method=RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue="") String text,
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate ) {
		text = URL.decodeParam(text);
		//0L - data mínima do sistema; new Date() - data atual
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);			
		return ResponseEntity.ok().body(list);
	}
}
