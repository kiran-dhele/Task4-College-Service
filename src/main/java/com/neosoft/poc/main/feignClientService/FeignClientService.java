package com.neosoft.poc.main.feignClientService;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.neosoft.poc.main.model.Student;

@FeignClient(name="StudentService",url = "http://localhost:9091")
public interface FeignClientService {
	
	@GetMapping("/student/studentFromCollegeId/{cid}")
	public List<Student> studentFromCollegeId(@PathVariable("cid") int id);

}
