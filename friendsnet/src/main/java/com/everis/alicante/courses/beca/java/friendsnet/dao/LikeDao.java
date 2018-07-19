package com.everis.alicante.courses.beca.java.friendsnet.dao;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Like;

public interface LikeDao extends CrudRepository<Like, Long>{

	public Like getByPersonId(Long personid);
}
