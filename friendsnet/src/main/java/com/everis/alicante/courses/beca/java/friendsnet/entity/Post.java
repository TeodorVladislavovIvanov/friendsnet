package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.PostType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "post_table")
public class Post implements FNEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postid")
	private Long id;
	private String text;
	@Temporal(TemporalType.DATE)
	private Date CreationDate;
	private PostType type;
	private Byte[] picture;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personid")
	private Person personPosts;

	@ManyToOne
	@JoinColumn(name = "eventid")
	private Event event;

	@OneToMany(mappedBy = "likes", cascade = { CascadeType.ALL })
	private Set<Like> likes;
}
