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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.LikeType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="like_table")
public class Like implements FNEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="likeid")
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	private LikeType type;
	
	@ManyToOne
	@JoinColumn(name = "personid")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "postid")
	private Post likes;
}
