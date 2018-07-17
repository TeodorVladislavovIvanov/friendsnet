package com.everis.alicante.courses.beca.java.friendsnet.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.courses.beca.java.friendsnet.controller.dto.EventDto;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.java.friendsnet.manager.EventManager;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventManager manager;
	
	@Autowired
    private DozerBeanMapper mapper;
	

	@SuppressWarnings("unchecked")
	@GetMapping("/")
	public List<Event> findAll(){
		return (List<Event>) mapper.map(manager.findAll(), EventDto.class);
	}
	
	@GetMapping("/{id}")
	public EventDto findById(@PathVariable("id")Long id) {
		return mapper.map(manager.findById(id), EventDto.class);
	}
}
