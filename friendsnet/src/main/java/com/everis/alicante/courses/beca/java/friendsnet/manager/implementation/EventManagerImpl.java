package com.everis.alicante.courses.beca.java.friendsnet.manager.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.java.friendsnet.dao.EventDao;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.java.friendsnet.manager.EventManager;

@Service
public class EventManagerImpl implements EventManager{
	
	@Autowired
	EventDao dao;
	

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
	public Iterable<Event> save(Iterable<Event> objeto) {
		return  dao.saveAll(objeto);
	}

	@Override
	public Event update(Event objeto) {
		if(findById(objeto.getId()) == objeto){
			return objeto;
		}
		return dao.save(objeto);
	}

	@Override
	public Iterable<Event> update(Iterable<Event> objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	

}