package com.everis.alicante.courses.beca.java.friendsnet.manager;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;
import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.LikeType;

public interface PostManager extends Manager<Post, Long> {
	
	public Post addLike(Long idPost, Long idPerson, LikeType type);
	
}
