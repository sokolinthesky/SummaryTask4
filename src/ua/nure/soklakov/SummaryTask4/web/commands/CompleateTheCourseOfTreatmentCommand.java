package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.patient.HospitalCard;
import ua.nure.soklakov.SummaryTask4.core.patient.Patient;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManager;
import ua.nure.soklakov.SummaryTask4.core.patient.PatientManagerImpl;
import ua.nure.soklakov.SummaryTask4.core.patient.Treatment;
import ua.nure.soklakov.SummaryTask4.core.patient.TypeOfTreatment;
import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.core.user.UserManager;
import ua.nure.soklakov.SummaryTask4.core.user.UserManagerImpl;
import ua.nure.soklakov.SummaryTask4.web.ActionType;

public class CompleateTheCourseOfTreatmentCommand extends Command {

	private static final long serialVersionUID = -5220729644390411869L;

	private static final Logger LOG = Logger.getLogger(CompleateTheCourseOfTreatmentCommand.class);

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

		PatientManager patientManager = new PatientManagerImpl();
		UserManager userManager = new UserManagerImpl();

		int hospitalCardId = (int) request.getSession().getAttribute("hospitalCardId");
		LOG.trace("Hospital card id: " + hospitalCardId);

		HospitalCard hospitalCard = patientManager.getHospitalCardById(hospitalCardId);

		List<Treatment> treatments = patientManager.getTreatmentsByCardId(hospitalCardId);

		Patient patient = patientManager.getPatientByHospitalCardId(hospitalCardId);
		LOG.trace("Patient data: id: " + patient.getId() + ", firstName: " + patient.getFirstName() + ", lastName: "
				+ patient.getLastName() + ",date: " + patient.getBirthday() + ", cardId: " + patient.getCardId()
				+ ", doctorID: " + patient.getDoctorId());

		User doctor = userManager.getUserById(patient.getDoctorId());

		// TODO: add write data to file
		try {
			PrintWriter writer = new PrintWriter(
					"C:/workspace_eclipse/SummaryTask4/WebContent/WEB-INF/DischangedPatients/" + patient.getFirstName()
							+ patient.getLastName() + ".txt",
					"UTF-8");

			writer.write("FirstName: " + patient.getFirstName() + "\r\n");
			writer.write("LastName: " + patient.getLastName() + "\r\n");
			writer.write("Diagmosis: " + hospitalCard.getDiagnosis() + "\r\n");
			writer.write("Doctor: " + doctor.getFirstName() + " " + doctor.getLastName() + "\r\n");
			writer.write("Treatments:\r\n");

			for (Treatment t : treatments) {
				writer.write(" TypeOfTreatment: " + TypeOfTreatment.getTypeOfTreatment(t) + " | Name: "
						+ t.getNameOfMedication() + " | isDone: " + t.isDone() + "\r\n");
			}

			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		patientManager.compleateTheCourseOfTreatment(patient);

		return Path.REDIRECT_TO_VIEW_DISCHARGED_PATIENTS;
	}

}
