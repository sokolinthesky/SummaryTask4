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

public class ListDischargedPatientsCommand extends Command {

	private static final long serialVersionUID = -6955018370847324597L;
	
	private static final Logger LOG = Logger.getLogger(ListDischargedPatientsCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("Start executing Command");

		String result = null;

		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		} 

		LOG.debug("Finished executing Command");

		return result;
	}
	
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		
		User doctor = (User) request.getSession().getAttribute("user");
		int doctorId = doctor.getId();
		LOG.trace("Doctor id: " + doctorId);
		
		PatientManager manager = new PatientManagerImpl();
		List<Patient> dischargedPatients = manager.getDischargedPatientsByDoctorId(doctorId);
		LOG.trace("Discarged patients: " + dischargedPatients);
		
		request.setAttribute("patients", dischargedPatients);
		 
		return Path.FORWARD_VIEW_DISCHARGED_PATIENTS;
	}

}
