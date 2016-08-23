package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManager;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManagerImpl;
import ua.nure.soklakov.SummaryTask4.web.ActionType;

/**
 * Appoint doctor to patient command.
 * 
 * @author Oleg Soklakov
 *
 */
public class AppointDoctorCommand extends Command {

	private static final long serialVersionUID = -8600308933491503281L;

	private static final Logger LOG = Logger.getLogger(AddPatientCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (ActionType.POST == actionType) {
			result = doPost(request, response);
		}

		LOG.debug("Finished executing Command");
		return result;
	}

	/**
	 * Redirect to view patients after submitting specified doctor to the
	 * patient.
	 * 
	 * @return path to view patients list.
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) {

		// get doctor and patient id
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		LOG.trace("Patient id: " + patientId + " Doctor id: " + doctorId);

		LOG.trace("Trying appoint doctor to the patient");
		PatientManager manager = new PatientManagerImpl();
		manager.setDoctorToPatient(patientId, doctorId);
		LOG.trace("The doctor was appointed to the patient");

		return Path.REDIRECT_TO_VIEW_ALL_PATIENTS;
	}

}
