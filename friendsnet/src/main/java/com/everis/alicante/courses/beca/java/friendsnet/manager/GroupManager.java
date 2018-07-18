package com.everis.alicante.courses.beca.java.friendsnet.manager;

import java.util.Set;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;

public interface GroupManager extends Manager<Group,Long>{
	Group addPersons(Group group, Set<Person> persons);
}
