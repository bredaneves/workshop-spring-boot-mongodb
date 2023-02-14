package com.alexandreneves.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alexandreneves.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
