package ua.nure.soklakov.SummaryTask4.core.user;

public enum Specialization {
	
	PEDIATRICIAN, TRAUMATOLOGIST, SURGEON;
	
	public static Specialization getSpecialization(User user) {
		int specializationId = user.getSpecializationId();
		return Specialization.values()[specializationId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}

}
