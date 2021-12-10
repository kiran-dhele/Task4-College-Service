package com.neosoft.poc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc.main.model.College;
import com.neosoft.poc.main.model.ResponseDemo;
import com.neosoft.poc.main.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	CollegeService collegeService;
	
//this uri is use to save college in database	
   @PostMapping("/saveCollege")
   public College saveCollege(@RequestBody College college)
   {
	   System.out.println(college.getId());
	   System.out.println(college.getCollegeName());
	   System.out.println(college.getCollegeCity());
	   College clg=collegeService.saveCollege(college);
	   return clg;
   }
   
 // this uri is use to get all college list form database  
   @GetMapping("/getCollege")
   public List<College> getCollege()
   {
	   List<College> list=collegeService.getCollege();
	   return list;
   }
   
//this uri is use to get single college by using its id   
   @RequestMapping(value = "/getSingleCollege/{id}", method = RequestMethod.GET)
   public College getSingleCollege(@PathVariable("id") int id)
   {  
	  College clg= collegeService.getSingleCollege(id);
	  return clg;
   }
   
//this uri is use to get all colleges list and there students list as per sequence.   
   @GetMapping("/getCollegeWithStudent")
   public List<ResponseDemo> getCollegeWithStudent()
   {
	   List<ResponseDemo> respDemo=collegeService.getCollegeWithStudent();
	   return respDemo;
   }
}
