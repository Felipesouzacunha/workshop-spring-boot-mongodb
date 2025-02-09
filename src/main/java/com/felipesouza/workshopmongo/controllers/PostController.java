package com.felipesouza.workshopmongo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipesouza.workshopmongo.controllers.util.URL;
import com.felipesouza.workshopmongo.domain.Post;
import com.felipesouza.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findBytitle(@RequestParam(value = "texto", defaultValue = " ") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "texto", defaultValue = " ") String text,
			@RequestParam(value = "minDate", defaultValue = " ") String minDate,
			@RequestParam(value = "maxdate", defaultValue = " ") String maxdate)  {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(minDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
	
}
