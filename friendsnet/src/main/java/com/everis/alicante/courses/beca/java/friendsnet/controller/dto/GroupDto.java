package com.everis.alicante.courses.beca.java.friendsnet.controller.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupDto {

	private Long id;
	private String name;
	private Byte[] picture;
	private Set<PersonDto> persons = new HashSet<>();

}
