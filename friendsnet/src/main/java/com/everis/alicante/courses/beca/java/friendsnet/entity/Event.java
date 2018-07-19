package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.EventType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "event_table")
public class Event implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventid")
	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date startingDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private EventType type;
	private Byte[] picture;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Post> posts;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "personid")
	private Set<Person> personsEvent;

}
