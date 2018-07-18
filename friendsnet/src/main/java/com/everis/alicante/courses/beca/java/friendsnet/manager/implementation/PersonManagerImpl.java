package com.everis.alicante.courses.beca.java.friendsnet.manager.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.java.friendsnet.dao.PersonDao;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.java.friendsnet.manager.PersonManager;

@Service
public class PersonManagerImpl implements PersonManager{

	@Autowired
	PersonDao dao;
	@Override
	public Iterable<Person> findAll() {
		return dao.findAll();
	}

	@Override
	public Person findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public Person save(Person person) {
		return dao.save(person);
	} 

	@Override
	public Iterable<Person> save(Iterable<Person> persons) {
		return dao.saveAll(persons);
	}

	@Override
	public Person update(Person person) {
		
		return dao.save(person);
	}

	@Override
	public Iterable<Person> update(Iterable<Person> persons) {
		return dao.saveAll(persons);
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Person relatePersons(Long personId, Iterable<Long> persons) {
		Person person = dao.findById(personId).get();
		List<Person> friends = (List<Person>) dao.findAllById(persons);
		person.getFriends().addAll(friends);
		dao.saveAll(friends);
		return person;
	}

}
