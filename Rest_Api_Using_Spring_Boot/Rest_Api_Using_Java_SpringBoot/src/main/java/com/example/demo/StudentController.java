package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	
	@GetMapping("/viewAll")
	public Iterable<Student> viewAll(){
		return ss.viewAll();
	}
	
	@PostMapping("/add")
	public String addStudent(@RequestBody Student s) {
		return ss.addStudent(s);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return ss.deleteStudent(id);
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return ss.deleteAll();
	}
	
	@GetMapping("/find/{id}")
	public Student searchStudent(@PathVariable int id) {
		return ss.searchStudent(id);
	}
}
