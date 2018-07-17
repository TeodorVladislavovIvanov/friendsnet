package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
    private Person friend;
	
	@OneToMany(mappedBy = "friend", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> persons;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Group> groups;
	
}
