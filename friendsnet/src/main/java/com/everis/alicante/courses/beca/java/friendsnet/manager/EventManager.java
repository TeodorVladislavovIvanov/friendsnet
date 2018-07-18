package com.everis.alicante.courses.beca.java.friendsnet.manager;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;

public interface EventManager extends Manager<Event,Long> {
	public Event addPerson(Long id, Long personid);
}
