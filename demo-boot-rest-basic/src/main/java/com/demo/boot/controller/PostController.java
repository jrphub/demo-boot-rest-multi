package com.demo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.boot.client.RestPostClient;
import com.demo.boot.model.Post;
import com.demo.boot.repository.PostRepository;


@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	RestPostClient postClient;
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPost(@PathVariable(value = "id") long id) {
		
		//Pass the id to call external rest API
		Post post = postClient.getPost(id);
		if (post == null) {
			return ResponseEntity.notFound().build();
			//throw new EntityNotFoundException(Trip.class, "id", tripId.toString());
		}
		
		//Save the result in local  database
		postRepo.save(post);
		
		return ResponseEntity.ok().body(post);
	}
}
