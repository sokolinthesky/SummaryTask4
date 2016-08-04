package ua.nure.soklakov.SummaryTask4.core.patient;

import ua.nure.soklakov.SummaryTask4.core.Entity;

/**
 * Treatment entity.
 * 
 * @author Oleg Soklakov
 *
 */
public class Treatment extends Entity {

	private static final long serialVersionUID = -897453822651366267L;
	
	private int typeOfTreatmentId;
	private int hospitalCardId;
	private String nameOfMedication;
	private boolean done;
	
	public Treatment(int id, int typeOfTreatmentId, int hospitalCardId, String nameOfMedication) {
		this.setId(id);
		this.typeOfTreatmentId = typeOfTreatmentId;
		this.hospitalCardId = hospitalCardId;
		this.nameOfMedication = nameOfMedication;
	}

	public int getTypeOfTreatmentId() {
		return typeOfTreatmentId;
	}

	public void setTypeOfTreatmentId(int typeOfTreatmentId) {
		this.typeOfTreatmentId = typeOfTreatmentId;
	}

	public int getHospitalCardId() {
		return hospitalCardId;
	}

	public void setHospitalCardId(int hospitalCardId) {
		this.hospitalCardId = hospitalCardId;
	}

	public String getNameOfMedication() {
		return nameOfMedication;
	}

	public void setNameOfMedication(String nameOfMedication) {
		this.nameOfMedication = nameOfMedication;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
