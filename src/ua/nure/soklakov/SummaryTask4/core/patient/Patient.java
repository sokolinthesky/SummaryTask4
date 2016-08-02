package ua.nure.soklakov.SummaryTask4.core.patient;

import java.sql.Date;

import ua.nure.soklakov.SummaryTask4.core.Entity;

/**
 * Patient entity.
 * 
 * @author Oleg Soklakov
 *
 */
public class Patient extends Entity {

	private static final long serialVersionUID = 2613496056932204312L;
	
	private String firstName;
	private String lastName;
	private Date birthday;
	private int doctorId;
	private String diagnos;
	private HospitalCard hospitalCard;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDiagnos() {
		return diagnos;
	}

	public void setDiagnos(String diagnos) {
		this.diagnos = diagnos;
	}

	public HospitalCard getHospitalCard() {
		return hospitalCard;
	}

	public void setHospitalCard(HospitalCard hospitalCard) {
		this.hospitalCard = hospitalCard;
	}

}
