package ua.nure.soklakov.SummaryTask4.core.patient;

import java.util.List;

import ua.nure.soklakov.SummaryTask4.dao.impl.PatientDaoImpl;

public class PatientManagerImpl implements PatientManager {
	private PatientDao patientDao = new PatientDaoImpl();

	@Override
	public List<Patient> getPatients() {
		return patientDao.getPatients();
	}

	@Override
	public void addPatient(Patient patient) {
		patientDao.addPatient(patient);
		
	}

	@Override
	public void setDoctorToPatient(int parientId, int doctoeId) {
		patientDao.setDoctorToPatient(parientId, doctoeId);
		
	}

	@Override
	public void updateDiagnosisInHospitalCard(int cardId, String diagnosis) {
		patientDao.updateDiagnosisInHospitalCard(cardId, diagnosis);
		
	}

	@Override
	public HospitalCard getHospitalCardById(int id) {
		return patientDao.getHospitalCardById(id);
	}

	@Override
	public int addHospitalCard() {
		return patientDao.addHospitalCard();
	}

	@Override
	public List<Treatment> getTreatmentsByCardId(int cardId) {
		return patientDao.getTreatmentsByCardId(cardId);
	}

	@Override
	public void addTreatment(Treatment treatment) {
		patientDao.addTreatment(treatment);
	}

	@Override
	public void finishTreatment(int treatmentId) {
		patientDao.finishTreatment(treatmentId);
	}

}
