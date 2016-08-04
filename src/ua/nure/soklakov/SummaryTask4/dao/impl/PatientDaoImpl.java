package ua.nure.soklakov.SummaryTask4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.core.patient.HospitalCard;
import ua.nure.soklakov.SummaryTask4.core.patient.Patient;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientDao;
import ua.nure.soklakov.SummaryTask4.core.patient.Treatment;
import ua.nure.soklakov.SummaryTask4.dao.ConnectionPool;
import ua.nure.soklakov.SummaryTask4.dao.Query;

/**
 * An implementation of PatientDao interface.
 * 
 * @author Oleg Soklakov
 *
 */
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
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pStatement = connection.prepareStatement(Query.INSERT_PATIENT)) {
			pStatement.setString(1, patient.getFirstName());
			pStatement.setString(2, patient.getLastName());
			pStatement.setDate(3, patient.getBirthday());
			pStatement.setInt(4, patient.getCardId());
			pStatement.setInt(5, patient.getDoctorId());
			pStatement.executeUpdate();

		} catch (SQLException ex) {
			LOG.error("Can not create a new patient", ex);
		} finally {
			closeConnection();
		}

	}

	@Override
	public void setDoctorToPatient(int parientId, int doctoeId) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pStatement = connection.prepareStatement(Query.SET_DOCTOR_TO_PATIENT)) {
			pStatement.setInt(1, doctoeId);
			pStatement.setInt(2, parientId);
			pStatement.executeUpdate();
		} catch (SQLException ex) {
			LOG.error("Can not set a doctor to the patient", ex);
		} finally {
			closeConnection();
		}

	}

	@Override
	public void updateDiagnosisInHospitalCard(int cardId, String diagnosis) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pStatement = connection.prepareStatement(Query.UPDATE_DIAGNOSIS)) {
			pStatement.setString(1, diagnosis);
			pStatement.setInt(2, cardId);
			pStatement.executeUpdate();
		} catch (SQLException ex) {
			LOG.error("Can not update diagnosis", ex);
		} finally {
			closeConnection();
		}

	}

	@Override
	public int addHospitalCard() {
		int cardId = 0;
		connection = ConnectionPool.getConnection();
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(Query.CREATE_HOSPITAL_CARD, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			if (rs != null && rs.next()) {
			    cardId = rs.getInt(1);
			}
		} catch (SQLException ex) {
			LOG.error("Can not create hospital card", ex);
		} finally {
			closeConnection();
		}
		
		return cardId;
	}

	@Override
	public void addTreatment(Treatment treatment) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pStatement = connection.prepareStatement(Query.INSERT_TREATMENT)) {
			pStatement.setInt(1, treatment.getHospitalCardId());
			pStatement.setInt(2, treatment.getTypeOfTreatmentId());
			pStatement.setString(3, treatment.getNameOfMedication());
			pStatement.executeUpdate();

		} catch (SQLException ex) {
			LOG.error("Can not create a new treatment", ex);
		} finally {
			closeConnection();
		}

	}

	@Override
	public void finishTreatment(int treatmentId) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pStatement = connection.prepareStatement(Query.UPDATE_FINISH_TREATMENT)) {
			pStatement.setInt(1, treatmentId);
			pStatement.executeUpdate();

		} catch (SQLException ex) {
			LOG.error("Can not finish treatment", ex);
		} finally {
			closeConnection();
		}

	}

	@Override
	public HospitalCard getHospitalCardById(int id) {
		connection = ConnectionPool.getConnection();
		HospitalCard card = null;
		try (PreparedStatement ps = connection.prepareStatement(Query.SELECT_HOSPITAL_CARD_BY_ID)) {
			ps.setInt(1, id);
			ps.execute();

			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				card = new HospitalCard(rs.getInt("id"), rs.getString("diagnosis"));
			}
			rs.close();
		} catch (SQLException ex) {
			LOG.error("Can not find hospital card by id", ex);
		} finally {
			closeConnection();
		}

		return card;
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
