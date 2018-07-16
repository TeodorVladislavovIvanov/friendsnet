package com.everis.alicante.courses.beca.java.friendsnet.controller.dto;

import java.util.List;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Event;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Group;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Like;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;

import lombok.Data;

@Data
public class PersonDto {

	private Long id;
	private String name;
	private String surname;
	
	private List<Person> persons;
	
	private List<Event> events;

	private List<Group> groups;
	
	private List<Like> likes;
	
	private List<Post> posts;
}
