package com.everis.alicante.courses.beca.java.friendsnet.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.java.friendsnet.controller.dto.PostDto;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.java.friendsnet.manager.PostManager;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostManager manager;
	
	@Autowired
    private DozerBeanMapper mapper;
	

	@SuppressWarnings("unchecked")
	@GetMapping("/")
	public List<Post> findAll(){
		return (List<Post>) mapper.map(manager.findAll(), PostDto.class);
	}
	
	@GetMapping("/{id}")
	public PostDto findById(@PathVariable("id")Long id) {
		return mapper.map(manager.findById(id), PostDto.class);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")Long id) {
		//manager.delete(id);
	}
	
	
}
