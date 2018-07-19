package com.everis.alicante.courses.beca.java.friendsnet.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;

public interface PersonDao extends CrudRepository<Person, Long> {

	@Override
	@Modifying
	@Query("UPDATE Person p SET p.isDeleted = true  WHERE p.id = :id")
	void deleteById(@Param("id") Long personId);

	@Override
	@Query("SELECT p FROM Person p WHERE p.isDeleted = false")
	Iterable<Person> findAll();
}
