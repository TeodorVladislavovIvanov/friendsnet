package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.List;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="person_table")
public class Person implements FNEntity{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="person_id")
	private Long id;
	private String name;
	private String surname;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	 
	@ManyToMany(fetch = FetchType.LAZY)
    private List<Person> friends;
	
	@ManyToMany(mappedBy = "friends", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> friends_1;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Group> groups;
	
}
