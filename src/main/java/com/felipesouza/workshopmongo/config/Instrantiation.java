package com.felipesouza.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipesouza.workshopmongo.domain.Post;
import com.felipesouza.workshopmongo.domain.User;
import com.felipesouza.workshopmongo.dto.AuthorDTO;
import com.felipesouza.workshopmongo.dto.CommentDTO;
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
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem, mano!", Instant.now(), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", Instant.now(), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", Instant.now(), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		
		postRepositry.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
	}

}
