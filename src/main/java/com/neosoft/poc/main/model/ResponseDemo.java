package com.neosoft.poc.main.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseDemo {

	private int id;
	private String collegeName;
	private String collegeCity;
	
	private List<Student> student=new ArrayList<>();
	
}
