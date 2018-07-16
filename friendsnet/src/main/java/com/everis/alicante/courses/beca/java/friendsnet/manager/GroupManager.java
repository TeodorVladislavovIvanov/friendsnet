package com.everis.alicante.courses.beca.java.friendsnet.manager;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;

public interface GroupManager extends Manager<Group>{

	Person addPerson(Iterable<Person> persons);
}
