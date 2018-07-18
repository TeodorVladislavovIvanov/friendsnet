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
	

	@GetMapping("/")
	public List<EventDto> findAll(){
		return (List<EventDto>) this.convertToDTO((List<Event>) manager.findAll());
	}

	protected List<EventDto> convertToDTO(List<Event> listaEvents) {
		final List<EventDto> list = new ArrayList<>();
		for (Event e : listaEvents) {
			list.add(this.convertToDTO(e));
		}
		return list;
	}

	protected EventDto convertToDTO(Event e) {
		return mapper.map(e, EventDto.class);
	}
	
	@GetMapping("/{id}")
	public EventDto findById(@PathVariable("id")Long id) {
		return mapper.map(manager.findById(id), EventDto.class);
	}
	
	@PostMapping
	public EventDto create(@RequestBody Event event) {
		return mapper.map(manager.save(event), EventDto.class);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		manager.delete(id);
	}

}
