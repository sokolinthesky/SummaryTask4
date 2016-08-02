package ua.nure.soklakov.SummaryTask4.core.patient;

import java.util.List;

import ua.nure.soklakov.SummaryTask4.core.Entity;

/**
 * Hospital card entity.
 * 
 * @author Oleg Soklakov
 *
 */
public class HospitalCard extends Entity {

	private static final long serialVersionUID = 8924384621418707436L;
	
	List<Treatment> treatments;

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

}
