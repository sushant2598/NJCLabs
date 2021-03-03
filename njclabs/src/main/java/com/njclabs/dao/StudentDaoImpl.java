package com.njclabs.dao;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.njclabs.entity.StudentEntity;
import com.njclabs.model.Student;

@Repository(value = "studentDaoImpl")
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addStudent(Student student) throws Exception {
		Integer studentId = null;
		if (Objects.nonNull(student)) {
			StudentEntity studentEntity = new StudentEntity();
			studentEntity.setName(student.getName());
			studentEntity.setFatherName(student.getFatherName());
			studentEntity.setMotherName(student.getMotherName());
			studentEntity.setAddress(student.getAddress());
			studentEntity.setMobileNumber(student.getMobileNumber());
			entityManager.persist(studentEntity);
			studentId = studentEntity.getStudentId();
		}
		return studentId;
	}

	@Override
	public Integer deleteStudent(Integer studentId) throws Exception {
		StudentEntity studentEntity = entityManager.find(StudentEntity.class, studentId);
		Integer studentIdRetrieved = null;
		if (Objects.nonNull(studentEntity)) {
			studentIdRetrieved = studentEntity.getStudentId();
			entityManager.remove(studentEntity);
		}
		return studentIdRetrieved;
	}

	@Override
	public Student getStudent(Integer studentId) throws Exception {
		Student student = null;
		StudentEntity studentEntity = entityManager.find(StudentEntity.class, studentId);
		if (Objects.nonNull(studentEntity)) {
			student = new Student();
			student.setStudentId(studentEntity.getStudentId());
			student.setName(studentEntity.getName());
			student.setFatherName(studentEntity.getFatherName());
			student.setMotherName(studentEntity.getMotherName());
			student.setAddress(studentEntity.getAddress());
			student.setMobileNumber(studentEntity.getMobileNumber());
		}
		return student;
	}

	@Override
	public Integer updateStudent(Student student) throws Exception {
		Integer studentId = null;
		StudentEntity studentEntity = entityManager.find(StudentEntity.class, student.getStudentId());
		if (Objects.nonNull(studentEntity)) {
			studentEntity.setName(student.getName());
			studentEntity.setFatherName(student.getFatherName());
			studentEntity.setMotherName(student.getMotherName());
			studentEntity.setAddress(student.getAddress());
			studentEntity.setMobileNumber(student.getMobileNumber());
			entityManager.persist(studentEntity);
			studentId = studentEntity.getStudentId();
		}
		return studentId;
	}
}