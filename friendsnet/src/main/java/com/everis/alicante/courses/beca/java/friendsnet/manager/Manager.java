package com.everis.alicante.courses.beca.java.friendsnet.manager;

import com.everis.alicante.courses.beca.java.friendsnet.entity.FNEntity;

public interface Manager<T extends FNEntity> {
	
	Iterable<T> findAll();
	T findById(Long id);
	
	void save(T objeto);
	
	void save(Iterable<T>objeto);
	
	void update(T objeto);
	
	void update(Iterable<T> objeto);
	
	void delete(T objeto);

}
