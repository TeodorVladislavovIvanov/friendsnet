package com.everis.alicante.courses.beca.java.friendsnet.manager.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.java.friendsnet.dao.GroupDao;
import com.everis.alicante.courses.beca.java.friendsnet.dao.PersonDao;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.java.friendsnet.manager.GroupManager;

@Service
public class GroupManagerImpl implements GroupManager{
	
	@Autowired
	private GroupDao dao;
	
	@Autowired
	private PersonDao personDao;

	@Override
	public Iterable<Group> findAll() {
		return dao.findAll();
	}

	@Override
	public Group findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public Group save(Group group) {
		return dao.save(group);
	}

	@Override
	public Iterable<Group> save(Iterable<Group> groups) {
		return dao.saveAll(groups);
	}

	@Override
	public Group update(Group group) {
		return dao.save(group);
	}

	@Override
	public Iterable<Group> update(Iterable<Group> groups) {
		return dao.saveAll(groups);
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Group addPersons(Long groupid, Iterable<Long> personsid) {
		Group group = dao.findById(groupid).orElse(null);
		if (group != null) {
			List<Person> aux = (List<Person>) personDao.findAllById(personsid);
			for (Person person : aux) {
				if (person != null) {
					group.getPersonsGroup().add(person);
					person.getGroups().add(group);
					personDao.save(person);
				}
			}
		}
		return dao.save(group);
	}
}
