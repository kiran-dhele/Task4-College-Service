package com.neosoft.poc.main.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Student {
	

	private int id;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private int collegeId;

}
