package com.everis.alicante.courses.beca.java.friendsnet.manager.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.java.friendsnet.dao.EventDao;
import com.everis.alicante.courses.beca.java.friendsnet.dao.PersonDao;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.java.friendsnet.manager.EventManager;

@Service
public class EventManagerImpl implements EventManager {

	@Autowired
	EventDao dao;

	@Autowired
	private PersonDao personDao;

	@Override
	public Iterable<Event> findAll() {
		return dao.findAll();
	}

	@Override
	public Event findById(Long id) {

		return dao.findById(id).get();
	}

	@Override
	public Event save(Event evento) {
		return dao.save(evento);
	}

	@Override
	public Iterable<Event> save(Iterable<Event> events) {
		return dao.saveAll(events);
	}

	@Override
	public Event update(Event event) {
		return dao.save(event);
	}

	@Override
	public Iterable<Event> update(Iterable<Event> events) {
		return dao.saveAll(events);
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	public Event addPerson(Long id, Long personid) {
		Event event = dao.findById(id).get();
		if (event != null) {
			Person person = personDao.findById(personid).get();
			if (person != null) {
				event.getPersonsEvent().add(person);
				person.getEvents().add(event);
				personDao.save(person);
			}
		}
		return dao.save(event);
	}

	public List<Event> findByPersonsId(Long id) {
		return dao.findBypersonsEventId(id);
	}
}