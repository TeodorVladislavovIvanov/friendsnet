package com.everis.alicante.courses.beca.java.friendsnet.controller.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.EventType;

import lombok.Data;

@Data
public class EventDto {

	private Long id;
	private String name;
	private Date startingDate;
	private Date endDate;
	private Byte[] picture;
	private EventType type;
	private Set<PersonDto> persons = new HashSet<>();
	
}
