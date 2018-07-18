package com.everis.alicante.courses.beca.java.friendsnet.manager;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;

public interface PersonManager extends Manager<Person,Long>{
	
	Person relatePersons(Long personId, Iterable<Long> persons);
}
