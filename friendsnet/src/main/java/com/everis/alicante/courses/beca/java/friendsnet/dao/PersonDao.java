package com.everis.alicante.courses.beca.java.friendsnet.dao;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;


public interface PersonDao extends CrudRepository<Person, Long>{

}
