package com.neosoft.poc.main.service;

import java.util.List;

import com.neosoft.poc.main.model.College;
import com.neosoft.poc.main.model.ResponseDemo;

public interface CollegeService {

	College saveCollege(College college);

	List<College> getCollege();

	College getSingleCollege(int id);

	List<ResponseDemo> getCollegeWithStudent();
	

}
