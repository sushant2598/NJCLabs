package com.njclabs.dao;

import com.njclabs.model.Student;


public interface StudentDao {

	public Integer addStudent(Student student) throws Exception;

	public Integer deleteStudent(Integer studentId) throws Exception;

	public Student getStudent(Integer studentId) throws Exception;

	public Integer updateStudent(Student student) throws Exception;

}