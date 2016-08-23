package ua.nure.soklakov.SummaryTask4.web.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.web.ActionType;

/**
 * Download discharged patient data command.
 * 
 * @author Oleg Soklakov
 *
 */
public class DownloadFileCommand extends Command {

	private static final long serialVersionUID = -6083396647578709168L;

	private static final Logger LOG = Logger.getLogger(DownloadFileCommand.class);

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

	/**
	 * Download specified file.
	 * 
	 * @return
	 * @throws IOException
	 */
	private String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LOG.debug("DownloadFileCommand starts");

		String patientName = request.getParameter("firstName");
		String patientLastName = request.getParameter("lastName");
		LOG.trace("First name: " + patientName + ", Last name: " + patientLastName);

		// to obtain the bytes for unsafe characters
		String fileName = URLEncoder.encode(patientName + patientLastName + ".txt", "UTF-8");
		String filePath = "C:/workspace_eclipse/SummaryTask4/WebContent/WEB-INF/DischangedPatients/" + patientName
				+ patientLastName + ".txt";

		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		File file = new File(filePath);

		// This should send the file to browser
		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(file);
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
