package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.user.Role;
import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.core.user.UserManager;
import ua.nure.soklakov.SummaryTask4.core.user.UserManagerImpl;
import ua.nure.soklakov.SummaryTask4.web.ActionType;

/**
 * Invoked when user logins in the system.
 *
 * @author Oleg Soklakov.
 *
 */
public class LoginCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {

		LOG.debug("Start executing Command");

		String result = null;

		if (actionType == ActionType.POST) {
			result = doPost(request, response);
		} else {
			result = null;
		}

		LOG.debug("End executing command");
		return result;
	}

	/**
	 * Logins user in system. As first page displays view of all faculties.
	 *
	 * @return path to the view of all faculties.
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		String forward = Path.ERROR_PAGE;

		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		UserManager manager = new UserManagerImpl();

		User user = manager.getUserByLogin(login);

		LOG.trace("User found: " + user);
		if (user == null || !password.equals(user.getPassword())) {
			request.setAttribute("errorMessage", "Cannot find user with such login/password");
			LOG.error("errorMessage: Cannot find user with such login/password");
		} else {
			Role userRole = Role.getRole(user);
			LOG.trace("userRole --> " + userRole);

			if (userRole == Role.ADMIN) {
				forward = Path.REDIRECT_TO_VIEW_ALL_DOCTORS;
			}

			if (userRole == Role.DOCTOR) {
				forward = Path.REDIRECT_TO_VIEW_PATIENTS_BY_DOCTOR_ID;
			}

			if (userRole == Role.NURSE) {
				forward = Path.REDIRECT_TO_VIEW_ALL_PATIENTS;
			}

			session.setAttribute("user", user);
			LOG.trace("Set the session attribute: user --> " + user);

			session.setAttribute("userRole", userRole);
			LOG.trace("Set the session attribute: userRole --> " + userRole);

			LOG.info("User " + user + " logged as " + userRole.toString().toLowerCase());
		}
		return forward;
	}

}