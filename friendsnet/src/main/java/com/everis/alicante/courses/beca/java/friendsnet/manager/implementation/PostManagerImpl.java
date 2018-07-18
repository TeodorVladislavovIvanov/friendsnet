package com.everis.alicante.courses.beca.java.friendsnet.manager.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.java.friendsnet.dao.PostDao;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.java.friendsnet.manager.PostManager;

@Service
public class PostManagerImpl implements PostManager {

	@Autowired
	PostDao dao;
	
	@Override
	public Iterable<Post> findAll() {
		return dao.findAll();
	}

	@Override
	public Post findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return dao.save(post);
	}

	@Override
	public Iterable<Post> save(Iterable<Post> posts) {
		return dao.saveAll(posts);
	}

	@Override
	public Post update(Post post) {
		return dao.save(post);
	}

	@Override
	public Iterable<Post> update(Iterable<Post> posts) {
		return dao.saveAll(posts);
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Post addLike(Long id, Like like) {
		return dao.addLike(id, like);
	}

}
