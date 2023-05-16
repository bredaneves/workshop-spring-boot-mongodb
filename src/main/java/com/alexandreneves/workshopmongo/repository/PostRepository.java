package com.alexandreneves.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alexandreneves.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
