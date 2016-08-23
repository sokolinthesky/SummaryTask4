package ua.nure.soklakov.SummaryTask4.web.utils.validation;

/**
 * Validation class contains common methods to validate data.
 * 
 * @author Oleg Soklakov
 *
 */
public class Validation {

	private static final String filledRegex = "^[а-яА-ЯёЁa-zA-Z][а-яА-ЯёЁa-zA-Z0-9-_\\.]{1,20}$";
	private static final String emailRegex = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";

	/**
	 * Validate fields.
	 * 
	 * @param values
	 *            specified fields.
	 * @return true if the validate success.
	 */
	public static boolean isFilled(String... values) {

		for (String value : values) {
			System.out.println(value + value.matches(filledRegex));
			if (!value.matches(filledRegex)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Validate email input.
	 * 
	 * @param email
	 *            specified email.
	 * @return true if validation success.
	 */
	public static boolean isCorrectEmail(String email) {
		if (!email.matches(emailRegex)) {
			return false;
		}
		return true;
	}
}
