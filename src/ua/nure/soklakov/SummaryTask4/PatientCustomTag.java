package ua.nure.soklakov.SummaryTask4;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import ua.nure.soklakov.SummaryTask4.core.patient.Patient;

/**
 * Patient custom tag. Displays on jsp row of table with patient data.
 * 
 * @author Oleg Soklakov
 *
 */
public class PatientCustomTag extends SimpleTagSupport {
	private Patient patient;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<td>" + patient.getFirstName() + "</td>");
		out.println("<td>" + patient.getLastName() + "</td>");
		out.println("<td>" + patient.getBirthday() + "</td>");
	}

}
