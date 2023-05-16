package com.alexandreneves.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alexandreneves.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
	//o final do nome do método pode ser uma palavra chave que é interpretado
	//vemos não haver implementação, pois o próprio nome indica a ação
	//ex: Containing, GreaterThan, In
	//o IgnoreCase é para não ser sensitivo
	List<Post> findByTitleContainingIgnoreCase(String text);

}
