package com.everis.alicante.courses.beca.java.friendsnet.manager;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Group;

public interface GroupManager extends Manager<Group, Long> {

	Group addPersons(Long groupid, Iterable<Long> personsid);

}
