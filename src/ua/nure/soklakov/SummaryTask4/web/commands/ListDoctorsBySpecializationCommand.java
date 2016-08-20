package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.core.user.UserManager;
import ua.nure.soklakov.SummaryTask4.core.user.UserManagerImpl;
import ua.nure.soklakov.SummaryTask4.web.ActionType;

/**
 * List doctors by specialization command.
 * 
 * @author Oleg Soklakov
 *
 */
public class ListDoctorsBySpecializationCommand extends Command {
	private static final long serialVersionUID = -7126747068896099191L;

	private static final Logger LOG = Logger.getLogger(ListDoctorsBySpecializationCommand.class);

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

	/**
	 * Forward user to page of all doctors. View type depends on the user id.
	 *
	 * @return to view of all doctors by specialization.
	 */
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		int specializationId = Integer.parseInt(request.getParameter("specializationId"));

		UserManager manager = new UserManagerImpl();

		Collection<User> doctors = manager.getDoctorsBySpecialization(specializationId);
		LOG.trace("Doctors found by specialization: " + doctors);

		request.setAttribute("doctors", doctors);

		return Path.FORWARD_VIEW_ALL_DOCTORS;
	}

}
