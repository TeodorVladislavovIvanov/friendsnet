package com.everis.alicante.courses.beca.java.friendsnet.manager;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;

public interface PostManager extends Manager<Post,Long>  {

	Post addLike(Like like);
}
