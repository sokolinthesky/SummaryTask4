package ua.nure.soklakov.SummaryTask4.web.commands;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Class that manages all commands.
 *
 * @author Mark Norkin
 *
 */
public class CommandManager {

	private static final Logger LOG = Logger.getLogger(CommandManager.class);

	private static Map<String, Command> commands = new HashMap<String, Command>();

	static {
		// common commands
		commands.put("login", new LoginCommand());
		
		
		// client commands
		commands.put("listPatients", new ListPatientsCommand());
		
		// admin commands
		commands.put("listDoctors", new ListDoctorsCommand());
		
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