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

import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.PostType;

import lombok.Data;

@Entity
@Data
@Table(name ="post_table")
public class Post implements FNEntity{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "postid")
	private Long id;
	private String text;
	private Date CreationDate;
	private PostType type;
	private Byte[] picture;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personid")
    private Person postsPerson;
	
	@ManyToOne
	@JoinColumn(name = "eventid")
	private Event event;
	
	@OneToMany(mappedBy = "likesPost", cascade = {CascadeType.ALL})
	private Set<Like> likes;
}
