package ua.nure.soklakov.SummaryTask4.core.patient;

import java.util.List;

/**
 * Patient manager.
 * 
 * @author Oleg Soklakov
 *
 */
public interface PatientManager {

	/**
	 * Get all patients.
	 * 
	 * @return list of patients.
	 */
	List<Patient> getPatients();

	/**
	 * Get treatments by hospital card id.
	 * 
	 * @param cardId
	 *            specified hospital card id.
	 * @return list of treatments.
	 */
	List<Treatment> getTreatmentsByCardId(int cardId);

	/**
	 * Get patients by doctor id.
	 * 
	 * @param doctorId
	 *            specified doctor id.
	 * @return list of patients
	 */
	List<Patient> getPatientsByDoctorId(int doctorId);

	/**
	 * Get all types of treatment.
	 * 
	 * @return list of types of treatment.
	 */
	List<TypeOfTreatment> getTypesOfTreatment();

	/**
	 * Get discharged patients by doctor id.
	 * 
	 * @param doctorId
	 *            specified doctor id.
	 * @return list of patients.
	 */
	List<Patient> getDischargedPatientsByDoctorId(int doctorId);

	/**
	 * Get hospital card by id.
	 * 
	 * @param id
	 *            specified id.
	 * @return hospital card entity.
	 */
	HospitalCard getHospitalCardById(int id);

	/**
	 * Get patient by hospital card id.
	 * 
	 * @param hospitalCardId
	 *            specified hospital card id.
	 * @return patient entity.
	 */
	Patient getPatientByHospitalCardId(int hospitalCardId);

	/**
	 * Create hospital card for new patient.
	 * 
	 * @return hospital card id.
	 */
	int addHospitalCard();

	/**
	 * Complete course of treatment for specified patient.
	 * 
	 * @param patient
	 *            specified patient.
	 */
	void completeTheCourseOfTreatment(Patient patient);

	/**
	 * Add patient.
	 * 
	 * @param patient
	 *            specified patient.
	 */
	void addPatient(Patient patient);

	/**
	 * Set doctor to patient.
	 * 
	 * @param parientId
	 *            specified patient id.
	 * @param doctoeId
	 *            specified doctor id.
	 */
	void setDoctorToPatient(int parientId, int doctoeId);

	/**
	 * Update patient diagnosis.
	 * 
	 * @param cardId
	 *            specified hospital card id.
	 * @param diagnosis
	 *            new diagnosis.
	 */
	void updateDiagnosisInHospitalCard(int cardId, String diagnosis);

	/**
	 * Add new treatment.
	 * 
	 * @param treatment
	 *            specified treatment.
	 */
	void addTreatment(Treatment treatment);

	/**
	 * Finish treatment.
	 * 
	 * @param treatmentId
	 *            specified treatment id.
	 */
	void finishTreatment(int treatmentId);
	
	/**
	 * Get patients by type of treatment 'operation'
	 * 
	 * @return list patients.
	 */
	List<Patient> getPatientsByTreatmentOperation();
}
