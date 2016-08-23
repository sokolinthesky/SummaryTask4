package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.patient.HospitalCard;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManager;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManagerImpl;
import ua.nure.soklakov.SummaryTask4.core.patient.Treatment;
import ua.nure.soklakov.SummaryTask4.core.patient.TypeOfTreatment;
import ua.nure.soklakov.SummaryTask4.web.ActionType;
import ua.nure.soklakov.SummaryTask4.web.utils.validation.HospitalCardInputValidator;

/**
 * Hospital card command.
 * 
 * @author Oleg Soklakov
 *
 */
public class HospitalCardCommand extends Command {
	private static final long serialVersionUID = -7519771294666045392L;

	private static final Logger LOG = Logger.getLogger(HospitalCardCommand.class);

	private PatientManager manager = new PatientManagerImpl();

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
	 * Forward to hospital card page.
	 * 
	 * @return path to hospital card page.
	 */
	private String doGet(HttpServletRequest request, HttpServletResponse response) {

		// get hospital card id
		int hospitalCardId;
		if (request.getParameter("hospitalCardId") == null) {
			hospitalCardId = (int) request.getSession().getAttribute("hospitalCardId");
		} else {

			// first reference to current hospital card
			hospitalCardId = Integer.parseInt(request.getParameter("hospitalCardId"));

			// set id to session for other references to current card
			request.getSession().setAttribute("hospitalCardId", hospitalCardId);
		}
		LOG.trace("Hospital card id: " + hospitalCardId);

		HospitalCard hospitalCard = manager.getHospitalCardById(hospitalCardId);
		LOG.trace("Hospital card entity: " + hospitalCard);

		List<Treatment> treatments = manager.getTreatmentsByCardId(hospitalCardId);
		LOG.trace("Treatments: " + treatments);

		// get type of treatments for add treatment form
		List<TypeOfTreatment> typeOfTreatments = manager.getTypesOfTreatment();
		LOG.trace("Type Of Treatments: " + typeOfTreatments);

		request.setAttribute("hospitalCard", hospitalCard);
		request.setAttribute("treatments", treatments);
		request.getSession().setAttribute("typesOfTreatments", typeOfTreatments);

		// error message if if fields not properly filled
		if (request.getParameter("error") != null) {
			String lang = (String) request.getSession().getAttribute("lang");
			String errorMessage = "";
			if (lang == null || lang.equals("en")) {
				errorMessage = "Inncorect input, try again";
			} else if (lang.equals("uk")) {
				errorMessage = "Не вірний ввод";
			}
			request.setAttribute("errorMessage", errorMessage);
		}

		return Path.FORWARD_HOSPITAL_CARD;
	}

	/**
	 * Redirect to view current hospital card.
	 * 
	 * @return path to view hospital card.
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		String diagnosis = request.getParameter("diagnosis");

		boolean valid = HospitalCardInputValidator.validateDiagnosis(diagnosis);
		if (!valid) {
			LOG.trace("Diagnosis not valid");
			return Path.REDIRECT_TO_VIEW_HOSPITAL_CARD + "&error=notValidDiagnosis";
		}

		LOG.trace("Diagnosis: " + diagnosis);

		int hospitalCardId = (int) request.getSession().getAttribute("hospitalCardId");
		LOG.trace("Hospital card id: " + hospitalCardId);

		manager.updateDiagnosisInHospitalCard(hospitalCardId, diagnosis);
		LOG.trace("Diagnosis was update");

		return Path.REDIRECT_TO_VIEW_HOSPITAL_CARD;
	}

}
