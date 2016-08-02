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
	
	void setDoctorToPatient(long parientId, int doctoeId);
	
	//void updatePatientDiagnosis(long patientId);
	
	void updatePatient(Patient patient);
	
	Treatment getTreatmentById(long id);
	
	//void addTreatment(Treatment treatment);
	
	void finishTreatment(long treatmentId);
	
	
}
