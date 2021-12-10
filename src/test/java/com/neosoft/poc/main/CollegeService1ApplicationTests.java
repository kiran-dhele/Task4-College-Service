package com.neosoft.poc.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.neosoft.poc.main.feignClientService.FeignClientService;
import com.neosoft.poc.main.model.College;
import com.neosoft.poc.main.model.ResponseDemo;
import com.neosoft.poc.main.model.Student;
import com.neosoft.poc.main.repository.CollegeRepo;
import com.neosoft.poc.main.serviceImpl.CollegeServiceImpl;

@SpringBootTest
class CollegeService1ApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@MockBean
	private CollegeRepo collegeRepo;
	
	@Autowired
	private CollegeServiceImpl collegeServiceImpl;
	
	@MockBean
	private FeignClientService feignClientServiceMock;
	
//	@Autowired
//	private FeignClientService feignClientService;
	
	@Test
	public void saveCollegeTest()
	{
		College clg=new College();
		clg.setId(2001);
		clg.setCollegeName("Sipna");
		clg.setCollegeCity("Amravati");
		
		when(collegeRepo.save(clg)).thenReturn(clg);
		assertEquals(clg, collegeServiceImpl.saveCollege(clg));
		assertNotNull(clg);
	}
	
	@Test
	public void getCollegeTest()
	{
		College clg=new College();
		clg.setId(2001);
		clg.setCollegeName("Sipna");
		clg.setCollegeCity("Amravati");
		
		College clg1=new College();
		clg1.setId(2002);
		clg1.setCollegeName("Raisoni College Of Engineering");
		clg1.setCollegeCity("Pune");
		
		List<College> list=new ArrayList<College>();
		list.add(clg1);
		list.add(clg);
		
		when(collegeRepo.findAll()).thenReturn(list);
		assertEquals(list, collegeServiceImpl.getCollege());
		assertNotNull(list);
	}
	
	@Test
	public void getSingleCollegeTest()
	{
		College clg1=new College();
		clg1.setId(2001);
		clg1.setCollegeName("Sipna");
		clg1.setCollegeCity("Amravati");
		
		when(collegeRepo.findById(clg1.getId())).thenReturn(clg1);
		assertEquals(clg1, collegeServiceImpl.getSingleCollege(clg1.getId()));
		assertNotNull(clg1);
	}
	
	@Test
	public void getCollegeWithStudent()
	{
		
		College clg=new College();
		clg.setId(2001);
		College clg1=new College();
		clg1.setId(2002);
		List<College> clist=new ArrayList<College>();
		clist.add(clg1);
		clist.add(clg);
		
		Student stu1=new Student();
		stu1.setId(101);
		Student stu2=new Student();
		stu1.setId(102);
		List<Student> list=new ArrayList<Student>();
	//	List<Student> list= ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		
		ResponseDemo respDemo=new ResponseDemo();
		respDemo.setId(102);
		respDemo.setCollegeName("xyz");
		respDemo.setCollegeCity("fdd");
		respDemo.setStudent(list);
		
		List<ResponseDemo> rlist=new ArrayList<ResponseDemo>();
		
		when(collegeRepo.findAll()).thenReturn(clist);
		when(feignClientServiceMock.studentFromCollegeId(stu1.getCollegeId())).thenReturn(list);
		
	
		assertEquals(collegeServiceImpl.getCollegeWithStudent(), rlist);
	}

}
