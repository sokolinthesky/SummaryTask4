package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.user.Specialization;
import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.core.user.UserManager;
import ua.nure.soklakov.SummaryTask4.core.user.UserManagerImpl;
import ua.nure.soklakov.SummaryTask4.web.ActionType;

/**
 * List of doctors command.
 * 
 * @author Oleg Soklakov
 *
 */
public class ListDoctorsCommand extends Command {
	private static final long serialVersionUID = 7723206619340362128L;

	private static final Logger LOG = Logger.getLogger(ListDoctorsCommand.class);

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
	 * Forward user to page of all doctors.
	 *
	 * @return path to view of all doctors page.
	 */
	private String doGet(HttpServletRequest request, HttpServletResponse response) {
		UserManager manager = new UserManagerImpl();

		Collection<User> doctors = manager.getDoctors();
		LOG.trace("Doctors found: " + doctors);

		Collection<Specialization> specializations = manager.getSpecializations();
		LOG.trace("Specializations found: " + specializations);

		request.setAttribute("doctors", doctors);
		request.getSession().setAttribute("specializations", specializations);

		return Path.FORWARD_VIEW_ALL_DOCTORS;
	}

}
