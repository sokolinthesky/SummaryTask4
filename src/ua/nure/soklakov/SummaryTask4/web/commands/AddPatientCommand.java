package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.patient.Patient;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManager;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManagerImpl;
import ua.nure.soklakov.SummaryTask4.web.ActionType;
import ua.nure.soklakov.SummaryTask4.web.utils.validation.PatientInputValidator;

public class AddPatientCommand extends Command {

	private static final long serialVersionUID = 2141162477716480717L;

	private static final Logger LOG = Logger.getLogger(AddPatientCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		} else if (ActionType.POST == actionType) {
			result = doPost(request, response);
		}

		LOG.debug("Finished executing Command");

		return result;
	}

	/**
	 * Forwards to add page.
	 *
	 * @return path to the add user page.
	 */
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		LOG.trace("Request for only showing addPatientForm.jsp");

		// error message if exist
		if (request.getParameter("error") != null) {
			String lang = (String) request.getSession().getAttribute("lang");
			String errorMessage = "";
			if (lang == null || lang.equals("en"))  {
				errorMessage = "Inncorect input or date, try again";
			} else if (lang.equals("uk")) {
				errorMessage = "Не вірний ввод, або дата";
			}
			request.setAttribute("errorMessage", errorMessage);
		}

		return Path.FORWARD_PATIENT_ADD;
	}

	/**
	 * Redirects user after submitting add user form.
	 *
	 * @return path to the view of added user if fields properly filled,
	 *         otherwise redisplays add Faculty page.
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date selectedDate = null;
		
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
			selectedDate = new Date(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		boolean valid = PatientInputValidator.validatePatientParametrs(firstName, lastName, selectedDate);

		if (valid) {
	
			LOG.trace("Fields were got: " + firstName + "," + lastName + ", " + selectedDate);

			Patient patient = new Patient(firstName, lastName, selectedDate);

			PatientManager manager = new PatientManagerImpl();
			int hospitalCardId = manager.addHospitalCard();
			patient.setCardId(hospitalCardId);
			manager.addPatient(patient);
			LOG.trace("The Patioen was added to database");
		} else {
			return Path.REDIRECT_TO_VIEW_ADD_PATIENT_FORM + "&error=notValid";
		}

		return Path.REDIRECT_TO_VIEW_ALL_PATIENTS;
	}

}
