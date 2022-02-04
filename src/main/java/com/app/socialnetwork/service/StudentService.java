package com.app.socialnetwork.service;

import java.util.List;

import com.app.socialnetwork.entity.Student;
import com.app.socialnetwork.exceptions.NoSuchStudentException;

public interface StudentService {
	public boolean addStudent(Student student);
	
	public Student findStudentById(int studentId)throws NoSuchStudentException;
	public Student findStudentByName(String studentName);
	public boolean removeStudentById(int studentId)  throws NoSuchStudentException;
	public boolean updateStudent(Student student);
	public List<Student> findAllStudents();
	
	public boolean loginStudent(Student student);
	
	
}
