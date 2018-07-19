package com.everis.alicante.courses.beca.java.friendsnet.controller.dto;

import java.util.Date;

import com.everis.alicante.courses.beca.java.friendsnet.entity.enums.LikeType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDto {
	
	private Long id;
	private Date creationDate;
	private LikeType type;
}
