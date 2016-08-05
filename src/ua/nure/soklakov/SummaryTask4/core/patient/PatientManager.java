package ua.nure.soklakov.SummaryTask4.core.patient;

import java.util.List;

public interface PatientManager {
	
	List<Patient> getPatients();

	void addPatient(Patient patient);

	void setDoctorToPatient(int parientId, int doctoeId);

	void updateDiagnosisInHospitalCard(int cardId, String diagnosis);

	HospitalCard getHospitalCardById(int id);

	int addHospitalCard();

	List<Treatment> getTreatmentsByCardId(int cardId);

	void addTreatment(Treatment treatment);

	void finishTreatment(int treatmentId);
}
