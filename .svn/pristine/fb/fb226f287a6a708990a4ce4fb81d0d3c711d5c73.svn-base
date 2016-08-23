package ua.nure.soklakov.SummaryTask4.dao;

/**
 * Contains all querys to data base.
 * 
 * @author Oleg Soklakov
 *
 */
public class Query {

	// user
	public static final String SELECT_ALL_DOCTORS = "SELECT * FROM users WHERE role_id = 1";
	public static final String SELECT_DOCTORS_BY_SPEC = "SELECT * FROM users WHERE specialization_id = (?)";
	public static final String INSERT_USER = "INSERT INTO users (login, password, first_name, last_name, role_id, specialization_id, count_of_patients) VALUES (?, ?, ?, ?,  ?, ?, ?)";
	public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM users WHERE login = (?)";
	public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = (?)";
	public static final String SELECT_ALL_ROLES = "SELECT * FROM roles";
	public static final String SELECT_ALL_SPECIALIZATIONS = "SELECT * FROM specializations";
	public static final String INCREMENT_COUNT_OF_PATIENTS = "UPDATE users SET count_of_patients=count_of_patients+1 WHERE id=?";
	public static final String DECREMENT_COUNT_OF_PATIENTS = "UPDATE users SET count_of_patients=count_of_patients-1 WHERE id=?";

	// patient
	public static final String SELECT_ALL_PATIENTS = "SELECT * FROM patients;";
	public static final String SELECT_PATIENTS_BY_DOCTOR_ID = "SELECT * FROM patients WHERE doctor_id = ?";
	public static final String INSERT_PATIENT = "INSERT INTO patients (first_name, last_name, birthday, card_id) VALUES (?,?,?,?)";
	public static final String SET_DOCTOR_TO_PATIENT = "UPDATE patients SET doctor_id = ? WHERE id = ?";
	public static final String UPDATE_DIAGNOSIS = "UPDATE hospital_card SET diagnosis = ? WHERE id = ?";
	public static final String CREATE_HOSPITAL_CARD = "INSERT INTO hospital_card (diagnosis) VALUE (null)";
	public static final String INSERT_TREATMENT = "INSERT INTO treatment (hospital_card_id, type_of_treatment_id, name_of_medication) VALUES (?, ?, ?)";
	public static final String UPDATE_FINISH_TREATMENT = "UPDATE treatment SET done = 1 WHERE id = ?";
	public static final String SELECT_HOSPITAL_CARD_BY_ID = "SELECT * FROM hospital_card WHERE id = ?";
	public static final String SELECT_TREATMENTS_BY_HOSPITAL_CARD = "SELECT * FROM treatment WHERE hospital_card_id = (?)";
	public static final String SELECT_ALL_TYPES_OF_TREATMENT = "SELECT * FROM type_of_treatment;";
	public static final String SELECT_PATIENT_BY_HOSPITAL_CARD_ID = "SELECT * FROM patients WHERE card_id = ?";
	public static final String SELECT_DISCHARGED_PATIENTS_BY_DOCTOR_ID = "SELECT * FROM discharged_patients WHERE doctor_id = ?";
	public static final String DELETE_PATIENT_BY_ID = "DELETE FROM patients WHERE id = ?";
	public static final String DELETE_HOSPITAL_CARD_BY_ID = "DELETE FROM hospital_card WHERE id = ?";
	public static final String INSERT_DISCHARGED_PATIENT = "INSERT INTO discharged_patients (first_name, last_name, birthday, doctor_id) VALUES (?, ?, ?, ?)";
	public static final String DELETE_TREATMENTS_BY_HOSPITAL_CARD_ID = "DELETE FROM treatment WHERE hospital_card_id = ?";
}
