package ua.nure.soklakov.SummaryTask4.web.utils.validation;

public class HospitalCardInputValidator {
	
	public static boolean validateDiagnosis(String diagnosis) {
		return Validation.isFilled(diagnosis);
	}
	
	public static boolean validateTreatmentParametrs(String nameOfaMedication) {
		return Validation.isFilled(nameOfaMedication);
	}

}
