package ua.nure.soklakov.SummaryTask4.web.commands;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Class that manages all commands.
 *
 * @author Soklakov Oleg
 *
 */
public class CommandManager {

	private static final Logger LOG = Logger.getLogger(CommandManager.class);

	private static Map<String, Command> commands = new HashMap<String, Command>();

	// initialization all commands
	static {
		// common commands
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("language", new LanguageCommand());
		commands.put("noCommand", new NoCommand());

		// doctor commands
		commands.put("listPatientsByDoctorId", new ListPatientsByDoctorCommand());
		commands.put("hospitalCard", new HospitalCardCommand());
		commands.put("addTreatment", new AddTreatmentCommand());
		commands.put("compleateTreatment", new PerformTreatmentCommand());
		commands.put("listDischargedPatients", new ListDischargedPatientsCommand());
		commands.put("compleateCourseOfTreatment", new CompleateTheCourseOfTreatmentCommand());
		commands.put("downloadFile", new DownloadFileCommand());

		// admin commands
		commands.put("listDoctors", new ListDoctorsCommand());
		commands.put("listDoctorsBySpecialization", new ListDoctorsBySpecializationCommand());
		commands.put("addUser", new AddUserCommand());
		commands.put("addPatient", new AddPatientCommand());
		commands.put("appointDoctor", new AppointDoctorCommand());
		commands.put("listPatients", new ListPatientsCommand());

		LOG.debug("Command container was successfully initialized");
		LOG.trace("Total number of commands equals to " + commands.size());
	}

	/**
	 * Returns command object which execution will give path to the resource.
	 *
	 * @param commandName
	 *            Name of the command.
	 * @return Command object if container contains such command, otherwise
	 *         specific <code>noCommand</code object will be returned.
	 */
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			LOG.trace("Command not found with name = " + commandName);
			return commands.get("noCommand");
		}

		return commands.get(commandName);
	}

}