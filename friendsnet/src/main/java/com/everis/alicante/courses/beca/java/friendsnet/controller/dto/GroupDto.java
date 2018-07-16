package com.everis.alicante.courses.beca.java.friendsnet.controller.dto;

import java.util.List;

import com.everis.alicante.courses.beca.java.friendsnet.entity.Person;

import lombok.Data;

@Data
public class GroupDto {

	private Long id;
	private String name;
	private List<Person> persons;
}
