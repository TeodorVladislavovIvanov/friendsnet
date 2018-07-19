package com.everis.alicante.courses.beca.java.friendsnet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;

public interface PostDao extends CrudRepository<Post, Long> {

	List<Post> findBypersonPostsId(Long id);
}
