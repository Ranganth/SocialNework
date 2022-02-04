package com.app.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.socialnetwork.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Modifying
	@Query(value="Update Student s set s.studentName = :name  where s.studentId = :id")
	public int updateStudent(@Param("name") String studentName, @Param("id") int studentId);

	
	@Query(value="Select s from Student s where  s.studentName = :name")
	public Student readBystudentName(@Param("name") String studentName);
	
	@Query(value ="Select s from Student s Where s.studentEmail = :email1 AND s.studentPassword = :password1 ") 
	  public Student readByEmailAndpassword(@Param("email1") String studentEmail, @Param("password1") String studentPassword);

}
