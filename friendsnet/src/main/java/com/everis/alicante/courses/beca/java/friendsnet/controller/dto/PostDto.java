package com.everis.alicante.courses.beca.java.friendsnet.controller.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.PostType;

import lombok.Data;

@Data
public class PostDto {

	private Long id;
	private String text;
	private Date CreationDate;
	private PostType type;
	private Set<LikeDto> likes = new HashSet<>();
	private PersonDto person;
}
