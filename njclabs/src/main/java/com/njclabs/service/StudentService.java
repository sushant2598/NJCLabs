package com.njclabs.service;

import com.njclabs.model.Student;

public interface StudentService {

	public Integer addStudent(Student student) throws Exception;

	public Integer deleteStudent(Integer studentId) throws Exception;

	public Student getStudent(Integer studentId) throws Exception;

	public Integer updateStudent(Student student) throws Exception;

}