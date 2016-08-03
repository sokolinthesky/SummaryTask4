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
	
	void addPatient(Patient patient);
	
	void setDoctorToPatient(int parientId, int doctoeId);
	
	//void updatePatientDiagnosis(long patientId);
	
	void updatePatient(Patient patient);
	
	Treatment getTreatmentById(int id);
	
	//void addTreatment(Treatment treatment);
	
	void finishTreatment(int treatmentId);
	
	
}
