package com.everis.alicante.courses.beca.java.friendsnet.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.java.friendsnet.controller.dto.GroupDto;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.java.friendsnet.manager.GroupManager;

@RestController
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	private GroupManager manager;
	
	@Autowired
    private DozerBeanMapper mapper;
	

	@SuppressWarnings("unchecked")
	@GetMapping("/")
	public List<Group> findAll(){
		return (List<Group>) mapper.map(manager.findAll(), GroupDto.class);
	}
	
	@GetMapping("/{id}")
	public GroupDto findById(@PathVariable("id")Long id) {
		return mapper.map(manager.findById(id), GroupDto.class);
	}
}
