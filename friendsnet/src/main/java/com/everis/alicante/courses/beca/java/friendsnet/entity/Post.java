package com.everis.alicante.courses.beca.java.friendsnet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="post_table")
public class Post implements FNEntity{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String text;
	private Date CreationDate;
	private PostType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Event event;
	
}
