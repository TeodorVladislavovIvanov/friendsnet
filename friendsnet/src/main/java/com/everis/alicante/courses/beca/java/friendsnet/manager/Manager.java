package com.everis.alicante.courses.beca.java.friendsnet.manager;

import com.everis.alicante.courses.beca.java.friendsnet.entity.FNEntity;

public interface Manager<T extends FNEntity, ID> {
	
	Iterable<T> findAll();
	T findById(ID id);
	
	T save(T objeto);
	
	Iterable<T> save(Iterable<T>objeto);
	
	T update(T objeto);
	
	Iterable<T> update(Iterable<T> objeto);
	
	void delete(ID id);

}
