package com.app.socialnetwork.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.socialnetwork.entity.Student;
import com.app.socialnetwork.exceptions.NoSuchStudentException;
import com.app.socialnetwork.service.StudentService;

@RestController


@CrossOrigin
@RequestMapping(path = "students")
public class StudentController {
	@Autowired
	private StudentService service;
	
	private Logger logger = LoggerFactory.getLogger(StudentController.class);
	//register/add/create student
	// http://machine-name:port-number/path-class/path-method
	// http://localhost:8080/students/ - Post
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		ResponseEntity<String> response = null;
		boolean result = service.addStudent(student);
		if (result)
			response = new ResponseEntity<String>("Student with id " + student.getStudentId() + " is added.",
					HttpStatus.CREATED);
		logger.info ( "addStudent API is called" + " studentId " );
		
		return response;
	}
	// http://localhost:8080/students/loginStudent/
			
			@PostMapping(path = "/loginStudent/")
			public ResponseEntity<String> getCustomerByEmailAndPassword(@RequestBody Student student) {
				ResponseEntity<String> response = null;
				boolean result = service.loginStudent(student);
				if (result) {
					response = new ResponseEntity<String>("Login successfully", HttpStatus.OK);
				} else {
					response = new ResponseEntity<String>("Login Failed , Please Enter Right Username and Passsword",
							HttpStatus.INTERNAL_SERVER_ERROR);
					logger.trace("Login Successfull");
				}
				return response;
			}
	
	//Update student
	// http://localhost:8080/students/ - Put
	@PutMapping(path = "/")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		ResponseEntity<String> response = null;
		boolean result = service.updateStudent(student);
		if (result)
			response = new ResponseEntity<String>("Student with id " + student.getStudentId() + " is updated.",
					HttpStatus.OK);
		return response;
	}
// read/find student by id
	// http://localhost:8080/students/searchById/10
	@GetMapping(path = "searchById/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId)throws NoSuchStudentException {
		ResponseEntity<Student> response = null;
		Student student = service.findStudentById(studentId);
		response = new ResponseEntity<Student>(student, HttpStatus.OK);
		logger.info ( "getStudentById API is called" + " studentId " + studentId );
		return response;
	}
	//delete student
	// http://localhost:8080/students/deleteById/1
		@DeleteMapping(path = "deleteById/{studentId}")
		public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") int studentId) throws NoSuchStudentException
				 {
			ResponseEntity<String> response = null;
			boolean result = service.removeStudentById(studentId);
			if (result)
				response = new ResponseEntity<String>("Student with id " + studentId + " is deleted.", HttpStatus.OK);
			return response;
		}
		//find student by name
		//http://localhost:8080/students/searchByName/
		@GetMapping(path = "/searchByName/{studentName}")
		public ResponseEntity <Student> getAllStudentsByName(@PathVariable("studentName") String studentName) {
			ResponseEntity<Student> response = null;
			Student list =service.findStudentByName(studentName);
			response = new ResponseEntity<Student>(list, HttpStatus.OK);
			
			return response;
		}
		//find all students
		// http://machine-name:port-number/context-path/path-class/path-method
		// http://localhost:9090/students/ - Get
		@GetMapping(path = "/")
		public ResponseEntity<List<Student>> getAllStudents() {
			ResponseEntity<List<Student>> response = null;
			List<Student> list = service.findAllStudents();
			response = new ResponseEntity<List<Student>>(list, HttpStatus.OK);
			return response;
		}

}
