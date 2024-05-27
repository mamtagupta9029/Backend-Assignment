package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepo sr;
	
	public Iterable<Student> viewAll(){
		return sr.findAll();
	}
	
	public String addStudent(Student s) {
		sr.save(s);
		return "Added";
	}
	
	public String deleteStudent(int id) {
		sr.deleteById(id);
		return "Deleted";
	}
	
	public Student searchStudent(int id) {
		return sr.findById(id).orElse(null);
	}
	
	public String deleteAll() {
		sr.deleteAll();
		return "Deleted all record";
	}
}
