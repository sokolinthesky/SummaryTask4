package ua.nure.soklakov.SummaryTask4.web.commands;

import org.apache.log4j.Logger;
import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.patient.Patient;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManager;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManagerImpl;
import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.web.ActionType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * List patients by doctor id command.
 * 
 * @author Oleg Soklakov
 *
 */
public class ListPatientsByDoctorCommand extends Command {

	private static final long serialVersionUID = -405445733126752744L;

	private static final Logger LOG = Logger.getLogger(ListPatientsByDoctorCommand.class);

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
	 * Forward to list of patients by doctor id page.
	 * 
	 * @return path to list of patients page.
	 */
	private String doGet(HttpServletRequest request, HttpServletResponse response) {

		// get doctor id
		User doctor = (User) request.getSession().getAttribute("user");
		int doctorId = doctor.getId();
		LOG.trace("Doctor id: " + doctorId);

		// find patients by doctor id
		PatientManager manager = new PatientManagerImpl();
		List<Patient> patients = manager.getPatientsByDoctorId(doctorId);
		LOG.trace("Patients were found by doctor id: " + patients);

		request.setAttribute("patients", patients);

		return Path.FORWARD_VIEW_ALL_PATIENTS;
	}

}
