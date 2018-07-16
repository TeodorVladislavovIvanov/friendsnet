package com.everis.alicante.courses.beca.java.friendsnet.controller.dto;

import java.util.Date;
import java.util.List;

import com.everis.alicante.courses.beca.java.friendsnet.entity.EventType;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;
import com.everis.alicante.courses.beca.java.friendsnet.entity.Post;

import lombok.Data;

@Data
public class EventDto {

	private Long id;
	private String name;
	private Date startingDate;
	private Date endDate;
	private EventType type;
	
	private List<Person> persons;
	
	private List<Post> posts;
}
