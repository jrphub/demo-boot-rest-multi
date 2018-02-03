package com.demo.boot.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.boot.model.Post;

@Service
public class RestPostClient {
	
	
	public Post getPost(long id) {
		RestTemplate restTemplate = new RestTemplate();
		//Calling the external Rest API
		Post post = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/"+id, Post.class);
		return post;
	}
	
}
