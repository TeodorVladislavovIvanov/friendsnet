package com.everis.alicante.courses.beca.java.friendsnet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;

public interface EventDao extends CrudRepository<Event, Long> {

	List<Event> findBypersonsEventId(Long id);
}
