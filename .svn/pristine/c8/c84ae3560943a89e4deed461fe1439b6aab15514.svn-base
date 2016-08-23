package ua.nure.soklakov.SummaryTask4.web.utils.validation;

/**
 * User input validator.
 * 
 * @author Oleg Soklakov
 *
 */
public class UserInputValidator {

	/**
	 * Validate user input data.
	 * 
	 * @param login
	 *            specified login
	 * @param password
	 *            specified password
	 * @param firstName
	 *            specified first name
	 * @param lastName
	 *            specified last name.
	 * @return true if validation success.
	 */
	public static boolean validateUserParametrs(String login, String password, String firstName, String lastName) {
		return Validation.isFilled(login, password, firstName, lastName);
	}

	/**
	 * Validate email input.
	 * 
	 * @param email
	 *            specified email.
	 * @return true if validation success.
	 */
	public static boolean validateEmail(String email) {
		return Validation.isCorrectEmail(email);
	}

}
