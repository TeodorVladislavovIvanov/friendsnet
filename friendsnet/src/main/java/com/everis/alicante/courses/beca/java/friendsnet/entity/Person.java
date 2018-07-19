package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.HashSet;
import java.util.Set;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="person_table")
public class Person implements FNEntity{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="personid")
	private Long id;
	private String name;
	private String surname;
	private Byte[] picture;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "friends", joinColumns = @JoinColumn(name = "personId"), inverseJoinColumns = @JoinColumn(name = "friendId"))
	private Set<Person> persons = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy="persons")
	private Set<Person> friends;
	
	@ManyToMany(mappedBy = "personsGroup", fetch = FetchType.LAZY)
    private Set<Group> groups;
	
	@OneToMany(mappedBy = "person")
	private Set<Like> like;
	
	@OneToMany(mappedBy = "postsPerson")
	private Set<Post> posts;
	
	@ManyToMany(mappedBy = "personsEvent", fetch = FetchType.LAZY)
	private Set<Event> events;
	
}
