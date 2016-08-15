package ua.nure.soklakov.SummaryTask4.core.patient;

import java.util.List;

/**
 * Patient dao interface.
 * 
 * @author Oleg Soklakov
 *
 */
public interface PatientDao {

	List<Patient> getPatients();

	List<Treatment> getTreatmentsByCardId(int cardId);

	List<Patient> getPatientsByDoctorId(int doctorId);

	List<TypeOfTreatment> getTypesOfTreatment();

	List<Patient> getDischargedPatientsByDoctorId(int doctorId);

	HospitalCard getHospitalCardById(int id);

	Patient getPatientByHospitalCardId(int hospitalCardId);
	
	int addHospitalCard();

	void compleateTheCourseOfTreatment(Patient patient);

	void addPatient(Patient patient);

	void setDoctorToPatient(int parientId, int doctoeId);

	void updateDiagnosisInHospitalCard(int cardId, String diagnosis);

	void addTreatment(Treatment treatment);

	void finishTreatment(int treatmentId);

}
