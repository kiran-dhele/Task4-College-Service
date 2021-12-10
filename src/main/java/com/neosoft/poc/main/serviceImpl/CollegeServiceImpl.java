package com.neosoft.poc.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.poc.main.feignClientService.FeignClientService;
import com.neosoft.poc.main.model.College;
import com.neosoft.poc.main.model.ResponseDemo;
import com.neosoft.poc.main.model.Student;
import com.neosoft.poc.main.repository.CollegeRepo;
import com.neosoft.poc.main.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	CollegeRepo collegeRepo;
	
	@Autowired()
	FeignClientService feignClientService;
	
	@Override
	public College saveCollege(College college) {
		// TODO Auto-generated method stub
		College clg=collegeRepo.save(college);
		return clg;
	}

	@Override
	public List<College> getCollege() {
		// TODO Auto-generated method stub
		List<College> list=collegeRepo.findAll();
		return list;
	}

	@Override
	public College getSingleCollege(int id) {
		// TODO Auto-generated method stub
		College clg=collegeRepo.findById(id);
		return clg;
	}

	@Override
	public List<ResponseDemo> getCollegeWithStudent() {
		// TODO Auto-generated method stub
		List<College> list=collegeRepo.findAll();
		
		List<ResponseDemo> rdList=new ArrayList<>();
		for(College college:list)
		{
			ResponseDemo respDemo=new ResponseDemo();
			List<Student> stu=feignClientService.studentFromCollegeId(college.getId());
			respDemo.setId(college.getId());
			respDemo.setCollegeName(college.getCollegeName());
			respDemo.setCollegeCity(college.getCollegeCity());
			respDemo.setStudent(stu);
			rdList.add(respDemo);
		}
		return rdList;
	}

}
