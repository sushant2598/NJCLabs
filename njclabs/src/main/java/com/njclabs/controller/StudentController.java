package com.njclabs.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njclabs.model.Student;
import com.njclabs.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private Environment environment;

	@PostMapping(value = "/{name}/{fatherName}/{motherName}/{address}/{mobileNumber}")
	public void addStudent(@PathVariable String name, @PathVariable String fatherName, @PathVariable String motherName,
			@PathVariable String address, @PathVariable String mobileNumber) {
		try {
			Student student = new Student();
			student.setName(name);
			student.setFatherName(fatherName);
			student.setMotherName(motherName);
			student.setAddress(address);
			student.setMobileNumber(mobileNumber);
			studentService.addStudent(student);
		} catch (Exception exception) {
			System.out.println(environment.getProperty(exception.getMessage()));
		}
	}

	@DeleteMapping(value = "/delete/{studentId}")
	public void deleteStudent(@PathVariable Integer studentId) {
		try {
			studentService.deleteStudent(studentId);
		} catch (Exception exception) {
			System.out.println(environment.getProperty(exception.getMessage()));
		}
	}

	@GetMapping(value = "/{studentId}")
	public Student getStudent(@PathParam(value = "studentId") Integer studentId) throws Exception {
		Student student=null; 
		//try {
			student= studentService.getStudent(studentId);
		//} catch (Exception exception) {
			//System.out.println(environment.getProperty(exception.getMessage()));
		//}
		return student;
	}

	@PutMapping(value = "/{name}/{fatherName}/{motherName}/{address}/{mobileNumber}")
	public void updateStudent(@PathVariable String name, @PathVariable String fatherName,
			@PathVariable String motherName, @PathVariable String address, @PathVariable String mobileNumber) {
		try {
			Student student = new Student();
			student.setName(name);
			student.setFatherName(fatherName);
			student.setMotherName(motherName);
			student.setAddress(address);
			student.setMobileNumber(mobileNumber);
			studentService.updateStudent(student);
		} catch (Exception exception) {
			System.out.println(environment.getProperty(exception.getMessage()));
		}
	}
} 