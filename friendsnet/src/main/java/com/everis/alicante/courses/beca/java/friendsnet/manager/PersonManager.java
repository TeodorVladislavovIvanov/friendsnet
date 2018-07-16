package com.everis.alicante.courses.beca.java.friendsnet.manager;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;

public interface PersonManager extends Manager<Person>{
	
	Iterable<Person> relatePersons();
}
