package ua.nure.soklakov.SummaryTask4.web.utils.validation;

import java.sql.Date;

/**
 * Validator for add patient input.
 * 
 * @author Oleg Soklakov
 *
 */
public class PatientInputValidator {

	/**
	 * Validate patient input data.
	 * 
	 * @param firstName
	 *            specified first name.
	 * @param lastName
	 *            specified last name.
	 * @param birthday
	 *            specified birthday.
	 * @return true if validation success.
	 */
	public static boolean validatePatientParametrs(String firstName, String lastName, Date birthday) {
		return (Validation.isFilled(firstName, lastName) && validateDate(birthday));
	}

	/**
	 * Validate date.
	 * 
	 * @param birthday
	 *            specified date.
	 * @return true if validation success.
	 */
	private static boolean validateDate(Date birthday) {

		if (birthday == null) {
			return false;
		}

		if (birthday.after(new java.util.Date())) {
			return false;
		}

		return true;
	}
}
