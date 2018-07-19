package com.everis.alicante.courses.beca.java.friendsnet.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.java.friendsnet.controller.dto.GroupDto;
import com.everis.alicante.courses.beca.java.friendsnet.controller.dto.PostDto;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.LikeType;
import com.everis.alicante.courses.beca.java.friendsnet.manager.implementation.PostManagerImpl;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostManagerImpl manager;

	@Autowired
	private DozerBeanMapper mapper;

	@GetMapping("/")
	public List<PostDto> findAll() {
		return (List<PostDto>) this.convertToDTO((List<Post>) manager.findAll());
	}

	protected List<PostDto> convertToDTO(List<Post> listaPosts) {
		final List<PostDto> list = new ArrayList<>();
		for (Post p : listaPosts) {
			list.add(this.convertToDTO(p));
		}
		return list;
	}

	protected PostDto convertToDTO(Post p) {
		return mapper.map(p, PostDto.class);
	}

	@GetMapping("/{id}")
	public PostDto findById(@PathVariable("id") Long id) {
		return mapper.map(manager.findById(id), PostDto.class);
	}

	@PostMapping
	public PostDto create(@RequestBody Post post) {
		return mapper.map(manager.save(post), PostDto.class);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		manager.delete(id);
	}

	@PostMapping("/{id}/person/{idperson}/like/{liketype}")
	public PostDto addLike(@PathVariable("id") Long id, @PathVariable("idperson") Long idperson,
			@PathVariable("liketype") LikeType type) {
		return mapper.map(manager.addLike(id, idperson, type), PostDto.class);
	}
	
	@GetMapping("/persons/{id}")
	public List<PostDto> findByPersonsId(@PathVariable("id") Long id) {
		List<Post> posts = manager.findByPersonsId(id);
		List<PostDto> postsDto = new ArrayList<>();
			for (Post post : posts) {
				postsDto.add(mapper.map(post, PostDto.class));
			}
		return postsDto;
	}

}
