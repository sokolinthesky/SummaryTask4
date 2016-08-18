package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.web.ActionType;

public class LanguageCommand extends Command {

	private static final long serialVersionUID = 1490694804984614045L;
	
	private static final Logger LOG = Logger.getLogger(LanguageCommand.class);

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
	
	private String doPost(HttpServletRequest request, HttpServletResponse response) {
		String partUrl = "controller?";
		
		String url = request.getParameter("url");
		String lang = request.getParameter("language");
		LOG.trace(partUrl + " " + url + " " + lang);
		
		// set language
		request.getSession().setAttribute("lang", lang);
		
		if (url.equals("command=logout") || url.equals("")) {
			return null;
		}
		
		return partUrl + url;
	}
	
	

}
