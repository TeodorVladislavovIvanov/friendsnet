package com.everis.alicante.courses.beca.java.friendsnet.manager.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.java.friendsnet.dao.EventDao;
import com.everis.alicante.courses.beca.java.friendsnet.dao.PersonDao;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.java.friendsnet.manager.EventManager;

@Service
public class EventManagerImpl implements EventManager{
	
	@Autowired
	EventDao dao;
	
	@Autowired
	private PersonDao personDAO;
	

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
		return  dao.saveAll(events);
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
	// Falta cosas
	public Event addPerson(Long id, Long idPerson) {
		Event event = dao.findById(id).orElse(null);
		if (null != event) {
			Person person = personDAO.findById(id).orElse(null);
			if (null != person) {
				event.getPersonsEvent().add(person);
				person.getEvents().add(event);
				personDAO.save(person);
			}
		}
		return dao.save(event);
	}

	

}