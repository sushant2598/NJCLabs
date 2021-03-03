package com.njclabs.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njclabs.dao.StudentDao;
import com.njclabs.model.Student;
import com.njclabs.validator.Validator;

@Service(value = "studentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Integer addStudent(Student student) throws Exception {
		Validator.validate(student);
		Integer studentId = studentDao.addStudent(student);
		if (studentId == null) {
			throw new Exception("Service.FAILURE");
		}
		return studentId;
	}

	@Override
	public Integer deleteStudent(Integer studentId) throws Exception {
		Integer studentIdFetched = studentDao.deleteStudent(studentId);
		if (studentIdFetched == null) {
			throw new Exception("Service.INVALID_ID" + " " + studentIdFetched);
		}
		return studentIdFetched;
	}

	@Override
	public Student getStudent(Integer studentId) throws Exception {
		Student student = studentDao.getStudent(studentId);
		if (Objects.isNull(student)) {
			throw new Exception("Service.INVALID_ID" + " " + studentId);
		}
		return student;
	}

	@Override
	public Integer updateStudent(Student student) throws Exception {
		Validator.validate(student);
		Integer studentId = studentDao.updateStudent(student);
		if (studentId == null) {
			throw new Exception("Service.INVALID_ID" + " " + studentId);
		}
		return studentId;
	}
}