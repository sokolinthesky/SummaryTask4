package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.core.user.Role;
import ua.nure.soklakov.SummaryTask4.core.user.Specialization;
import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.core.user.UserManager;
import ua.nure.soklakov.SummaryTask4.core.user.UserManagerImpl;
import ua.nure.soklakov.SummaryTask4.web.ActionType;
import ua.nure.soklakov.SummaryTask4.web.utils.MailUtils;

public class AddUserCommand extends Command {

	private static final long serialVersionUID = 3315917092461024179L;

	private static final Logger LOG = Logger.getLogger(AddUserCommand.class);

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
		LOG.trace("Request for only showing addUserForm.jsp");

		UserManager manager = new UserManagerImpl();

		List<Role> roles = manager.getRoles();
		LOG.trace("All roles found: " + roles);

		List<Specialization> specializations = manager.getSpecializations();
		LOG.trace("All specializations found: " + specializations);

		request.setAttribute("roles", roles);
		request.setAttribute("specializations", specializations);
		LOG.trace("All roles and specializations added like attributes");

		return Path.FORWARD_USER_ADD;
	}

	/**
	 * Redirects user after submitting add user form.
	 *
	 * @return path to the view of added user if fields properly filled,
	 *         otherwise redisplays add Faculty page.
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firsName");
		String lastName = request.getParameter("lastName");
		String email = null;
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		int specializationId = 0;
		int countOfPatients = 0;
		if (request.getParameter("specializationId") != null) {
			specializationId = Integer.parseInt(request.getParameter("specializationId"));
		}
		if (request.getParameter("email") != null) {
			email = request.getParameter("email");
		}
		
		//TODO validations fields

		LOG.trace("The fields got: " + login + " " + password + " " + firstName + " " + lastName + " " + roleId + " "
				+ specializationId + ", email: " + email);
		
		User user = new User(login, password, firstName, lastName, roleId, specializationId, countOfPatients);
		LOG.trace("User was created: " + user);
		
		UserManager manager = new UserManagerImpl();
		manager.addUser(user);
		LOG.trace("User was added to database");
		
		// Sent email
		if(email != null) {
			MailUtils.sendConfirmationEmail(user, email);
		}

		return Path.REDIRECT_TO_VIEW_ALL_DOCTORS;
	}

}
