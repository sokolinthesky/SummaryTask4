package ua.nure.soklakov.SummaryTask4.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.core.patient.Patient;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientDao;
import ua.nure.soklakov.SummaryTask4.core.patient.Treatment;
import ua.nure.soklakov.SummaryTask4.dao.ConnectionPool;
import ua.nure.soklakov.SummaryTask4.dao.Query;

public class PatientDaoImpl implements PatientDao {

	private final static Logger LOG = Logger.getLogger(PatientDaoImpl.class);

	private Connection connection;

	@Override
	public List<Patient> getPatients() {
		List<Patient> patients = new ArrayList<>();
		connection = ConnectionPool.getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.SELECT_ALL_PATIENTS)) {
			while (rs.next()) {
				patients.add(new Patient(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getDate("birthday"), rs.getInt("doctor_id"), rs.getInt("card_id")));
			}

		} catch (SQLException ex) {
			LOG.error("Can not find a patients", ex);
		} finally {
			closeConnection();
		}
		return patients;
	}

	@Override
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDoctorToPatient(int parientId, int doctoeId) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void updateDiagnosisInHospitalCard(int cardId, String diagnosis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTreatment(Treatment treatment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finishTreatment(int treatmentId) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * The method closes connection.
	 */
	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
