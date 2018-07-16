package com.everis.alicante.courses.beca.java.friendsnet.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.java.friendsnet.controller.dto.PersonDto;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.java.friendsnet.manager.PersonManager;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonManager manager;
	
	@Autowired
    private DozerBeanMapper mapper;
	

	@SuppressWarnings("unchecked")
	@GetMapping("/")
	public List<Person> findAll(){
		return (List<Person>) mapper.map(manager.findAll(), PersonDto.class);
	}
	
	@GetMapping("/{id}")
	public PersonDto findById(@PathVariable("id")Long id) {
		return mapper.map(manager.findById(id), PersonDto.class);
	}
	
	
}
