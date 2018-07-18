package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.LikeType;

import lombok.Data;

@Entity
@Data
@Table(name ="like_table")
public class Like implements FNEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="likeid")
	private Long id;
	private Date creationDate;
	private LikeType type;
	
	@ManyToOne
	@JoinColumn(name = "personid")
	private Person likesPerson;
	
	@ManyToOne
	@JoinColumn(name = "postid")
	private Post likesPost;
}
