package ua.nure.soklakov.SummaryTask4.core.patient;

/**
 * Types of treatment that can be use.
 * 
 * @author Oleg Soklakov
 *
 */
public enum TypeOfTreatment {
	PROCEDURE, MEDICINE, OPERATION;

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static TypeOfTreatment getTypeOfTreatment(Treatment treatment) {
		int typeOfTreatmentId = treatment.getTypeOfTreatmentId();
		return TypeOfTreatment.values()[typeOfTreatmentId - 1];
	}

	public String getName() {
		return name().toLowerCase();
	}
}
