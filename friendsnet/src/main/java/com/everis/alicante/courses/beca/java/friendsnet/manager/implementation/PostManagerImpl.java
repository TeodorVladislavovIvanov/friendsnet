package com.everis.alicante.courses.beca.java.friendsnet.manager.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.courses.beca.java.friendsnet.dao.LikeDao;
import com.everis.alicante.courses.beca.java.friendsnet.dao.PersonDao;
import com.everis.alicante.courses.beca.java.friendsnet.dao.PostDao;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.LikeType;
import com.everis.alicante.courses.beca.java.friendsnet.manager.PostManager;

@Service
public class PostManagerImpl implements PostManager {

	@Autowired
	PostDao postDao;

	@Autowired
	PersonDao personDao;

	@Autowired
	LikeDao likeDao;

	@Override
	public Iterable<Post> findAll() {
		return postDao.findAll();
	}

	@Override
	public Post findById(Long id) {
		return postDao.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return postDao.save(post);
	}

	@Override
	public Iterable<Post> save(Iterable<Post> posts) {
		return postDao.saveAll(posts);
	}

	@Override
	public Post update(Post post) {
		return postDao.save(post);
	}

	@Override
	public Iterable<Post> update(Iterable<Post> posts) {
		return postDao.saveAll(posts);
	}

	@Override
	public void delete(Long id) {
		postDao.deleteById(id);
	}

	@Override
	public Post addLike(Long postId, Long personId, LikeType likeType) {
		Post post = postDao.findById(postId).get();
		Person person = personDao.findById(personId).get();
		if (post == null && person == null) {
			return post;
		} else {
			Like like = likeDao.getByPersonId(personId);
			if (like != null) {
				like.setType(likeType);
				likeDao.save(like);
			} else {
				like = likeCreator(postId, personId, likeType);
				post.getLikes().add(like);
				person.getLike().add(like);
				postDao.save(post);
			}
		}
		return post;
	}

	protected Like likeCreator(Long idPost, Long idPerson, LikeType likeType) {
		Like like = new Like();
		like.setLikes(postDao.findById(idPost).get());
		like.setPerson(personDao.findById(idPerson).get());
		like.setType(likeType);
		like.setCreationDate(new Date());
		return like;
	}

	public List<Post> findByPersonsId(Long id) {
		return postDao.findBypersonPostsId(id);
	}

}
