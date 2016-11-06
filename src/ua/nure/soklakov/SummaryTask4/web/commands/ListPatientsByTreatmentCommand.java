package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.patient.Patient;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManager;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManagerImpl;
import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.web.ActionType;

public class ListPatientsByTreatmentCommand extends Command {

	private static final long serialVersionUID = 1635079837283036506L;

	private static final Logger LOG = Logger.getLogger(ListPatientsByTreatmentCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");
		String result = null;

		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		} else {
			result = doPost(request, response);
		}

		LOG.debug("Command finished");
		return result;
	}

	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		PatientManager manager = new PatientManagerImpl();

		// get patients by treatment type operation
		List<Patient> patients = manager.getPatientsByTreatmentOperation();

		request.setAttribute("patients", patients);

		return Path.FORWARD_GET_PATIENTS;
	}

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
