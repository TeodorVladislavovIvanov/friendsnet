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
import com.everis.alicante.courses.beca.java.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.java.friendsnet.manager.implementation.GroupManagerImpl;

@RestController
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	private GroupManagerImpl manager;
	
	@Autowired
    private DozerBeanMapper mapper;
	

	
	@GetMapping("/")
	public List<GroupDto> findAll(){
		return (List<GroupDto>) this.convertToDTO((List<Group>) manager.findAll());
	}
	
	protected List<GroupDto> convertToDTO(List<Group> listaGroups) {
		final List<GroupDto> list = new ArrayList<>();
		for (Group g : listaGroups) {
			list.add(this.convertToDTO(g));
		}
		return list;
	}

	protected GroupDto convertToDTO(Group g) {
		return mapper.map(g, GroupDto.class);
	}
	
	@GetMapping("/{id}")
	public GroupDto findById(@PathVariable("id")Long id) {
		return mapper.map(manager.findById(id), GroupDto.class);
	}
	
	@PostMapping
	public GroupDto create(@RequestBody Group group) {
		return mapper.map(manager.save(group),GroupDto.class);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		manager.delete(id);
	}
	
	@PostMapping("/{id}/relate")
	public GroupDto relate(@PathVariable Long id, @RequestBody List<Long> persons) {
		return mapper.map(manager.addPersons(id, persons), GroupDto.class);
	}
	/*
	@GetMapping("/person/{id}")
	public List<GroupDto> getByPersonId(@PathVariable("id") Long id) {
		List<Group> groups = manager.findByPersonsId(id);
		List<GroupDto> listDto = new ArrayList<>();
			for (Group group : groups) {
				listDto.add(mapper.map(group, GroupDto.class));
			}
		
		return listDto;
	}
	*/
}
