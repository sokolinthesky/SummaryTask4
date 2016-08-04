package ua.nure.soklakov.SummaryTask4;

public class Path {
	
	public static final String ERROR_PAGE = "";
	public static final String WELCOME_PAGE = "";
	
	public static final String FORWARD_VIEW_ALL_DOCTORS = "/WEB-INF/jsp/listDoctors.jsp";
	public static final String FORWARD_VIEW_ALL_PATIENTS = "/WEB-INF/jsp/listPatients.jsp";
	
	public static final String REDIRECT_TO_VIEW_ALL_DOCTORS = "controller?command=listDoctors";
	public static final String REDIRECT_TO_VIEW_ALL_PATIENTS = "controller?command=listPatients";

}
