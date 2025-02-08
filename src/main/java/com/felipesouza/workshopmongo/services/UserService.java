package com.felipesouza.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesouza.workshopmongo.domain.User;
import com.felipesouza.workshopmongo.dto.UserDTO;
import com.felipesouza.workshopmongo.repository.UserRepository;
import com.felipesouza.workshopmongo.services.exception.EntityNotFoundException;
import com.felipesouza.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {

		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}

	public void delete(String id) {
		try {
		User user = findById(id);
		repository.delete(user);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
	}

	public User update(String id, User obj) {

		try {
			User user = findById(id);
			updateData(user, obj);
			return repository.save(user);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Objeto não encontrado! ");
		}

	}

	private void updateData(User userEntity, User obj) {
		userEntity.setName(obj.getName());
		userEntity.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}

}
