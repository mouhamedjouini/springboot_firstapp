package com.springboot.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	// http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("med","jouini");
		
	}
	// http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> Students = new ArrayList<>();
		Students.add(new Student("med","jio"));
		Students.add(new Student("med1","jio2"));
		return Students;
		
	}
	// http://localhost:8080/student/1
	// @PathVariable annotation
	@GetMapping("/student/{firstName}/{lastName}")
		public Student studentPathVariable(@PathVariable("firstName") String
		firstName, @PathVariable("lastName") String lastName) {
		return new Student(firstName, lastName);
		}
	// http://localhost:8080/student/query?firstName=mm&lastName=ff
		@GetMapping("/student/query")
		public Student studentQueryParam(
		@RequestParam(name = "firstName") String firstName,
		@RequestParam(name = "lastName") String lastName) {
		return new Student(firstName, lastName);
		}
	

}
