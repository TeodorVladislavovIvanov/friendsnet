package com.everis.alicante.courses.beca.java.friendsnet.controller.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

	private Long id;
	private String name;
	private String surname;
	private Byte[] picture;
	private Set<FriendDto> friendDto;
}
