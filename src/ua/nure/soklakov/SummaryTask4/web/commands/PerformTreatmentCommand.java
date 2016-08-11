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

public class PerformTreatmentCommand extends Command {

	private static final long serialVersionUID = 6738405211563400773L;

	private static final Logger LOG = Logger.getLogger(PerformTreatmentCommand.class);

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
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		
		int treatmentId = Integer.parseInt(request.getParameter("id"));
		LOG.trace("Treatment id: " + treatmentId);
		
		PatientManager manager = new PatientManagerImpl();
		manager.finishTreatment(treatmentId);
		
		return Path.REDIRECT_TO_VIEW_HOSPITAL_CARD;
	}

}
