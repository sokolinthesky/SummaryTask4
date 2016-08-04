package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.web.ActionType;

public class ListDoctorsCommand extends Command {

	private static final long serialVersionUID = 7723206619340362128L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		String result = null;
		
		if (ActionType.GET == actionType) {
			result = doGet(request, response);
		}
		
		
		return result;
	}
	
	private String doGet(HttpServletRequest request,
			HttpServletResponse response) {

		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			list.add("test");
		}
		
		request.setAttribute("list", list);
		
		return Path.FORWARD_VIEW_ALL_DOCTORS;
	}

}
