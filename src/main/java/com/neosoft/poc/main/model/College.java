package com.neosoft.poc.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Setter
@Getter
@ToString
@Document(collection = "college")
public class College {
	
	@Id
	private int id;
	private String collegeName;
	private String collegeCity;
}
