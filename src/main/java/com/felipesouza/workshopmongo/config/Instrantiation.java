package com.felipesouza.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipesouza.workshopmongo.domain.Post;
import com.felipesouza.workshopmongo.domain.User;
import com.felipesouza.workshopmongo.repository.PostRepository;
import com.felipesouza.workshopmongo.repository.UserRepository;

@Configuration
public class Instrantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepositry;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepositry.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje", maria);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepositry.saveAll(Arrays.asList(post1, post2));
		
	}

}
