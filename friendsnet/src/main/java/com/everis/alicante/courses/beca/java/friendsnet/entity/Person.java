package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="person_table")
public class Person implements FNEntity{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="person_id")
	private Long id;
	private String name;
	private String surname;
	
	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Persons_Persons", joinColumns = {@JoinColumn(name = "person_id")}, inverseJoinColumns = {@JoinColumn(name = "person_id")})
	private List<Person> persons;
	*/
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Events_Persons", joinColumns = {@JoinColumn(name = "event_id")}, inverseJoinColumns = {@JoinColumn(name = "person_id")})
	private List<Event> events;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Groups_Persons", joinColumns = {@JoinColumn(name = "group_id")}, inverseJoinColumns = {@JoinColumn(name = "person_id")})
	private List<Group> groups;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="person")
	private List<Like> likes;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Posts_Persons", joinColumns = {@JoinColumn(name = "post_id")}, inverseJoinColumns = {@JoinColumn(name = "person_id")})
	private List<Post> posts;
	
}
