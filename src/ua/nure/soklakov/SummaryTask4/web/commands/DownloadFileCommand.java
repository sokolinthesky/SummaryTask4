package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.Path;
import ua.nure.soklakov.SummaryTask4.web.ActionType;

public class DownloadFileCommand extends Command {

	private static final long serialVersionUID = -6083396647578709168L;

	private static final Logger LOG = Logger.getLogger(DownloadFileCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionType actionType)
			throws IOException, ServletException {
		LOG.debug("DownloadFileCommand starts");

		String patientName = new String(request.getParameter("firstName").getBytes("ISO-8859-1"), "UTF-8");
		String patientLastName = new String(request.getParameter("lastName").getBytes("ISO-8859-1"), "UTF-8");
		// to obtain the bytes for unsafe characters
		String fileName = URLEncoder.encode(patientName + patientLastName + ".txt", "UTF-8");
		//fileName = URLDecoder.decode(fileName, "ISO8859_1");
		String filePath = "C:/workspace_eclipse/SummaryTask4/WebContent/WEB-INF/DischangedPatients/" + patientName
				+ patientLastName + ".txt";

		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		File my_file = new File(filePath);

		// This should send the file to browser
		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(my_file);
		byte[] buffer = new byte[4096];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.flush();

		LOG.debug("DownloadFileCommand finished");
		return null;
	}
}
