package com.app.socialnetwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("student")
@Scope("prototype")
@Entity
@Table(name = "STUDENT_MASTER")
public class Student {
	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;

	@Column(name = "STUDENT_NAME", length = 50)
	@NotEmpty(message = "Please Enter STUDENT Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Please Enter Valid Name.")
	private String studentName;

	@Column(name = "EMAIL", length = 70)
	private String studentEmail;

	@Column(name = "STUDENT_USERNAME", length = 50)
	@NotEmpty(message = "Please Enter Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Please Enter Valid UserName.")
	private String studentUserName;
	
	@Column(name = "STUDENT_PASSWORD", length = 20)
	private String studentPassword;

	@Column(name = "STUDENT_PHONE", length = 20)
	private long studentPhone;

	@Column(name = "STUDENT_ADDRESS", length = 50)
	@NotEmpty(message = "Please Enter ADDRESS")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Please Enter Valid UserName.")
	private String studentAddress;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentUserName() {
		return studentUserName;
	}

	public void setStudentUserName(String studentUserName) {
		this.studentUserName = studentUserName;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public long getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(long studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentUserName=" + studentUserName + ", studentPassword=" + studentPassword + ", studentPhone="
				+ studentPhone + ", studentAddress=" + studentAddress + "]";
	}

}
