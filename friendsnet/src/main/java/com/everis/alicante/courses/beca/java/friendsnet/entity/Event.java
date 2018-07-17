package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name ="event_table")
public class Event implements FNEntity{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="event_id")
	private Long id;
	private String name;
	private Date startingDate;
	private Date endDate;
	private EventType type;
	
	
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts;
	
}
