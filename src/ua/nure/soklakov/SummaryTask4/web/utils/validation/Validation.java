package ua.nure.soklakov.SummaryTask4.web.utils.validation;

public class Validation {

	private static final String isLatin = "[a-zA-Z ]+";
	private static final String isCyrillic = "[а-яА-Я ]+";
	private static final String filledRegex = "^[а-яА-ЯёЁa-zA-Z][а-яА-ЯёЁa-zA-Z0-9-_\\.]{1,20}$";
	private static final String emailRegex = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";

	public static boolean isFilled(String... values) {

		for (String value : values) {
			System.out.println(value + value.matches(filledRegex));
			if (!value.matches(filledRegex)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isCyrillicWord(String... values) {

		for (String value : values) {
			if (!value.matches(isCyrillic)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isLatinWord(String... values) {

		for (String value : values) {
			if (!value.matches(isLatin)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isCorrectEmail(String email) {
		if (!email.matches(emailRegex)) {
			return false;
		}
		return true;
	}
}
