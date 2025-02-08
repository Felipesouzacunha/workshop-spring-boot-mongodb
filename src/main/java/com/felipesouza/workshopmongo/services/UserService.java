package com.felipesouza.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesouza.workshopmongo.domain.User;
import com.felipesouza.workshopmongo.repository.UserRepository;
import com.felipesouza.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		
		User obj = repository.findById(id).orElse(null);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		return obj;

	}
}
