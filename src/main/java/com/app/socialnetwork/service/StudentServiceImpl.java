package com.app.socialnetwork.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.socialnetwork.entity.Student;
import com.app.socialnetwork.exceptions.NoSuchStudentException;
import com.app.socialnetwork.repository.StudentRepository;
@Service("service")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repository;
	@Override
	public boolean addStudent(Student student) {
		boolean result = false;
		student = repository.save(student);
		if(student.getStudentId() > 0)
			result = true;
		return result;
	}

	@Override
	public Student findStudentById(int studentId) throws NoSuchStudentException{
		if(repository.existsById(studentId)) {
			return repository.findById(studentId).get();
			
			}
		throw new NoSuchStudentException("Student with id "+studentId+" not found.");
		}
	

	@Override
	public boolean removeStudentById(int studentId) throws NoSuchStudentException {
		if(repository.existsById(studentId)) {
			repository.deleteById(studentId);
			return true;
			
		}
		
		throw new NoSuchStudentException("Student with id "+studentId+" not found.");
	}
	@Transactional
	@Override
	
	public boolean updateStudent(Student student) {
		repository.updateStudent(student.getStudentName(), student.getStudentId());
		return true;
	}

	@Override
	public List<Student> findAllStudents() {
		return repository.findAll();
	}

	@Override
	public Student findStudentByName(String studentName) {
		return repository.readBystudentName(studentName);
	
	}
	

	@Override
	public boolean loginStudent(Student student) {
		boolean result = false;
		Student student2 = repository.readByEmailAndpassword(student.getStudentEmail(), student.getStudentPassword());
		if(student2!=null) {
			result = true;
		}
		return result;
	}

	
	
}
