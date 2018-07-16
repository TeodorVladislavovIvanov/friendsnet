package com.everis.alicante.courses.beca.java.friendsnet.controller.dto;

import java.util.Date;
import java.util.List;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.java.friendsnet.entity.PostType;

import lombok.Data;

@Data
public class PostDto {

	private Long id;
	private String text;
	private Date CreationDate;
	private PostType type;
	
	private List<Event> events;
	
	private List<Person> persons;
	
	private List<Like> likes;
}
