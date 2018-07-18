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

	@GetMapping("/")
	public List<PersonDto> findAll() {
		return (List<PersonDto>) this.convertToDTO((List<Person>) manager.findAll());
	}

	protected List<PersonDto> convertToDTO(List<Person> listaPersonas) {
		final List<PersonDto> list = new ArrayList<>();
		for (Person p : listaPersonas) {
			list.add(this.convertToDTO(p));
		}
		return list;
	}

	protected PersonDto convertToDTO(Person p) {
		return mapper.map(p, PersonDto.class);
	}

	@GetMapping("/{id}")
	public PersonDto findById(@PathVariable("id") Long id) {
		return mapper.map(manager.findById(id), PersonDto.class);
	}

	@PostMapping
	public PersonDto create(@RequestBody Person person) {
		return mapper.map(manager.save(person), PersonDto.class);
	}

	@PostMapping("/{id}/relate")
	public PersonDto relate(@PathVariable Long id, @RequestBody List<Long> persons) {
		return mapper.map(manager.relatePersons(id, persons), PersonDto.class);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		manager.delete(id);
	}
}
