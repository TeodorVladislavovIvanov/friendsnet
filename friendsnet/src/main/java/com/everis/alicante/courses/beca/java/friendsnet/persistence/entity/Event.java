package com.everis.alicante.courses.beca.java.friendsnet.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Event {

	private Long id;
	private String name;
	private Date startingDate;
	private Date endDate;
	
}
