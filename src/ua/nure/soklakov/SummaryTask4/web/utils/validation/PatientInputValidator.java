package ua.nure.soklakov.SummaryTask4.web.utils.validation;

import java.sql.Date;


public class PatientInputValidator {

	public static boolean validatePatientParametrs(String firstName, String lastName, Date birthday) {
		return (Validation.isFilled(firstName, lastName) && validateDate(birthday));
	}

	private static boolean validateDate(Date birthday) {

		if(birthday == null) {
			return false;
		}
		
		if (birthday.after(new java.util.Date())) {
			return false;
		}
		
		return true;
	}
}
