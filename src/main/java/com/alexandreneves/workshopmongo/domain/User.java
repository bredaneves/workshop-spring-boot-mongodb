package com.alexandreneves.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//a notação abaixo é o equivalente a entidade no banco tradicional
//a indicação da coleção (equivalente a tabela) é opcional, pois... 
//por padrão, assume-se o nome da classe em minúsculo
@Document(collection="user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	
	//a notação abaixo indica uma lista de referência dentro do objeto JSON
	//o parâmetro lazy indica que não queremos carregar essa lista quando um usuário é criado
	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();
	
	public User() {		
	}

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}	
	
}
