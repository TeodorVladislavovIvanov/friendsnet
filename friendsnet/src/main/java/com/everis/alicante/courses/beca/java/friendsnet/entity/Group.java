package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="group_table")
public class Group implements FNEntity{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "groupid")
	private Long id;
	private String name;
	private Byte[] picture;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "personid")
    private Set<Person> personsGroup;
}
