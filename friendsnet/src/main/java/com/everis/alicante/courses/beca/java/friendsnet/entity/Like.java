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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="like_table")
public class Like implements FNEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="like_id")
	private Long id;
	private Date creationDate;
	private LikeType type;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Person person;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy="likes", cascade=CascadeType.ALL)
	private List<Post> posts;
}
