package ua.nure.soklakov.SummaryTask4.core.user;

/**
 * Specialization that can be used.
 * 
 * @author Oleg Soklakov
 *
 */
public enum Specialization {

	PEDIATRICIAN, TRAUMATOLOGIST, SURGEON;

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Specialization getSpecialization(User user) {
		int specializationId = user.getSpecializationId();
		return Specialization.values()[specializationId];
	}

	public String getName() {
		return name().toLowerCase();
	}

}
