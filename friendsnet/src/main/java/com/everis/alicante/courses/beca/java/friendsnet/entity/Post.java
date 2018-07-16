package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="post_table")
public class Post implements FNEntity{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;
	private String text;
	private Date CreationDate;
	private PostType type;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Events_Posts", joinColumns = {@JoinColumn(name = "post_id")}, inverseJoinColumns = {@JoinColumn(name = "event_id")})
	private List<Event> events;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="posts", cascade=CascadeType.ALL)
	private List<Person> persons;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Likes_Posts", joinColumns = {@JoinColumn(name = "post_id")}, inverseJoinColumns = {@JoinColumn(name = "like_id")})
	private List<Like> likes;
	
	
}
