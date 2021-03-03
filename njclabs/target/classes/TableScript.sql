CREATE TABLE Student(
student_id Number(10) CONSTRAINT studentIdPK PRIMARY KEY,
name VARCHAR2(30) CONSTRAINT studentname NOT NULL,
father_name VARCHAR2(40) CONSTRAINT fatherName UNIQUE NOT NULL,
mother_name VARCHAR2(40) CONSTRAINT motherName UNIQUE NOT NULL,
address VARCHAR2(40) CONSTRAINT address UNIQUE NOT NULL,
mobile_number VARCHAR2(10) CONSTRAINT mobileNumber UNIQUE NOT NULL);