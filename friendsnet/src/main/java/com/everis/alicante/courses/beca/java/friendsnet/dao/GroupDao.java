package com.everis.alicante.courses.beca.java.friendsnet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Group;

public interface GroupDao extends CrudRepository<Group, Long> {

	List<Group> findByPersonsId(Long id);
}
