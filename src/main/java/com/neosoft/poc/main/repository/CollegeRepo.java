package com.neosoft.poc.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.poc.main.model.College;

@Repository
public interface CollegeRepo extends MongoRepository<College, Integer>{

	public College findById(int id);
}
