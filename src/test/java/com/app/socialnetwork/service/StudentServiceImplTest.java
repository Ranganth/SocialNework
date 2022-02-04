package com.app.socialnetwork.service;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.app.socialnetwork.entity.Student;
import com.app.socialnetwork.exceptions.NoSuchStudentException;



@SpringBootTest

public class StudentServiceImplTest {
	@Autowired
	private StudentService service;

	@Autowired
	private ApplicationContext context;

	@Test
	void testFindStudentByIdShouldReturnStudent() throws NoSuchStudentException {
		Student expected = context.getBean(Student.class);
		expected.setStudentName("Test");
		expected.setStudentEmail("vasavigpcet@gmail.com");
		expected.setStudentUserName("Test");
		expected.setStudentPassword("abcwr");
		expected.setStudentPhone(964250694);
		expected.setStudentAddress("kurnool");
		

		service.addStudent(expected);
		Student actual = service.findStudentById(expected.getStudentId());

		// assertEquals(expected, actual);
		assertEquals(expected.getStudentId(), actual.getStudentId());
		assertEquals(expected.getStudentName(), actual.getStudentName());
		assertEquals(expected.getStudentEmail(), actual.getStudentEmail());
		assertEquals(expected.getStudentUserName(), actual.getStudentUserName());
		assertEquals(expected.getStudentPassword(), actual.getStudentPassword());
		assertEquals(expected.getStudentPhone(), actual.getStudentPhone());
		assertEquals(expected.getStudentAddress(), actual.getStudentAddress());
		service.removeStudentById(expected.getStudentId());
	}

	@Test
	public void testShouldThrowNoSuchStudentException() {
		Student expected = context.getBean(Student.class);
		NoSuchStudentException exception = Assertions.assertThrows(NoSuchStudentException.class, () -> {
			service.findStudentById(expected.getStudentId());
		});

	}

}
