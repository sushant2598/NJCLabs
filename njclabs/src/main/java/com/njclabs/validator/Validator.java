package com.njclabs.validator;

import com.njclabs.model.Student;

public class Validator {

	public static void validate(Student student) throws Exception {
		if (!validateName(student.getName())) {
			throw new Exception("Validator.INVALID_NAME");
		}
		if (!validateName(student.getFatherName())) {
			throw new Exception("Validator.INVALID_FATHERNAME");
		}
		if (!validateName(student.getMotherName())) {
			throw new Exception("Validator.INVALID_MOTHERNAME");
		}
		if (!validateAddress(student.getAddress())) {
			throw new Exception("Validator.INVALID_ADRESS");
		}
		if (!validateMobileNumber(student.getMobileNumber())) {
			throw new Exception("Validator.INVALID_MOBILENUMBER");
		}
	}

	private static Boolean validateName(String name) {
		return (name.matches("^[a-z ,.'-]+$"));
	}

	private static Boolean validateMobileNumber(String mobileNumber) {
		return (mobileNumber.matches("^[6|7|8|9][0-9]{9}$"));
	}

	private static Boolean validateAddress(String address) {
		return (address.matches("^[a-z 0-9 \\\\ \\/ ,.'-]+$"));
	}
}