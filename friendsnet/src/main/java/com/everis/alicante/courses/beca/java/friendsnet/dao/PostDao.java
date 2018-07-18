package com.everis.alicante.courses.beca.java.friendsnet.dao;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;

public interface PostDao extends CrudRepository<Post, Long>{
	//public Post addLike(Long id, Like like);
}
