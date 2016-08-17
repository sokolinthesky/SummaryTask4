package ua.nure.soklakov.SummaryTask4.web.utils.validation;

public class UserInputValidator {
	
	public static boolean validateUserParametrs(String login, String password, String firstName, String lastName) {
		return Validation.isFilled(login, password, firstName, lastName);
	}
	
	public static boolean validateEmail(String email) {
		return Validation.isCorrectEmail(email);
	}

}
