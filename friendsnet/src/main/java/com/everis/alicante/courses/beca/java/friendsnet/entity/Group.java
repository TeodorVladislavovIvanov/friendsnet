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
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="group_table")
public class Group implements FNEntity{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="group_id")
	private Long id;
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy="groups", cascade=CascadeType.ALL)
	private List<Person> persons;
}
