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
	private int cardId;

	public Patient(int id, String firstName, String lastName, Date birthday, int doctorId, int cardId) {
		this.setId(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.doctorId = doctorId;
		this.cardId = cardId;

	}
	
	public Patient(String firstName, String lastName, Date birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;

	}

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

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
