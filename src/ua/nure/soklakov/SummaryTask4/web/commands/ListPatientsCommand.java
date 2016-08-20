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
import ua.nure.soklakov.SummaryTask4.web.ActionType;

/**
 * List of all patients in the hospital command.
 * 
 * @author Oleg Soklakov
 *
 */
public class ListPatientsCommand extends Command {
	private static final long serialVersionUID = -2063322913213017032L;

	private static final Logger LOG = Logger.getLogger(ListPatientsCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");
		String result = null;

		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		}
		LOG.debug("Command finished");
		return result;
	}

	/**
	 * Forward to list of all patients page.
	 * 
	 * @return path to page.
	 */
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		PatientManager manager = new PatientManagerImpl();
		List<Patient> patients = manager.getPatients();
		LOG.trace("Count of patients: " + patients.size());

		request.setAttribute("patients", patients);

		return Path.FORWARD_VIEW_ALL_PATIENTS;
	}

}
