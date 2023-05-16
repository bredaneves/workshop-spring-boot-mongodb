package com.alexandreneves.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.alexandreneves.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
	//método personalizado
	//nesse caso, precisamos da documentação do MongoDB para consultar os padrões regex
	//https://docs.mongodb.com/manual/reference/operator/query/regex/
	//?0 - indica o primeiro parâmetro passado no método
	//options i - ignorar maiúsculas e minúsculas
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	//o final do nome do método pode ser uma palavra chave que é interpretado
	//vemos não haver implementação, pois o próprio nome indica a ação
	//ex: Containing, GreaterThan, In
	//o IgnoreCase é para não ser sensitivo
	List<Post> findByTitleContainingIgnoreCase(String text);

	@Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
