package ua.nure.soklakov.SummaryTask4.dao.impl;

import java.sql.Date;

import org.junit.*;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import ua.nure.soklakov.SummaryTask4.core.patient.Patient;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientDao;
import ua.nure.soklakov.SummaryTask4.core.patient.Treatment;
import ua.nure.soklakov.SummaryTask4.dao.ConnectionPool;

public class PatientDaoImplTest {
	private static PatientDao patienDao = null;
	private static int hospitalCardId;
	private static Patient testPatient;
	private static Treatment testTretment;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void beforeClass() {
		patienDao = new PatientDaoImpl();
		testPatient = new Patient("test", "test", new Date(2006, 2, 2));
		testTretment = new Treatment(0, 1, hospitalCardId, "test", false);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
			dataSource.setURL("jdbc:mysql://localhost:3306/hospitaldb?useEncoding=true&amp;characterEncoding=UTF-8");
			dataSource.setUser("root");
			dataSource.setPassword("root");
			new ConnectionPool(dataSource);
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot get DataSource without JNDI");
		}
	}

	@Test
	public void testGetListPatients() {
		Assert.assertNotNull(patienDao.getPatients());
	}

	@Test
	public void testGetTypesOfTreatment() {
		Assert.assertNotNull(patienDao.getTypesOfTreatment());
	}

	@Test
	public void testGetPatientsByDoctorId() {
		Assert.assertNotNull(patienDao.getPatientsByDoctorId(2));
	}

	@Test
	public void testAddPatientWithHospitalCarrd() {
		hospitalCardId = patienDao.addHospitalCard();

		testPatient.setCardId(hospitalCardId);
		patienDao.addPatient(testPatient);
	}

	@Test
	public void testSetDoctorToPatient() {
		patienDao.setDoctorToPatient(0, 2);
	}

	@Test
	public void testUpdateDiagnosisInHospitalCard() {
		patienDao.updateDiagnosisInHospitalCard(hospitalCardId, "testDiagnosis");
	}

	@Test
	public void testAddTreatmentAndGetTreamentByHospitalCardId() {
		testTretment.setHospitalCardId(hospitalCardId);
		patienDao.addTreatment(testTretment);
		Assert.assertNotNull(patienDao.getTreatmentsByCardId(hospitalCardId));
	}

	@Test
	public void testFinishTreatment() {
		patienDao.finishTreatment(testTretment.getId());
	}

	@Test
	public void testGetDischargedPatirnts() {
		Assert.assertTrue(patienDao.getDischargedPatientsByDoctorId(2).size() > 0);
	}

	@Test
	public void testComplrateCourseOfTreatment() {
		patienDao.completeTheCourseOfTreatment(testPatient);
	}

	@Test
	public void testGetHospitalCardById() {
		int id = 2;
		if (hospitalCardId != 0) {
			id = hospitalCardId;
		}
		Assert.assertNotNull(patienDao.getHospitalCardById(id));
	}

	@Test
	public void testGetPatientByHospitalCardId() {
		int id = 2;
		if (hospitalCardId != 0) {
			id = hospitalCardId;
		}
		Assert.assertNotNull(patienDao.getPatientByHospitalCardId(id));
	}
}
