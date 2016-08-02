package ua.nure.soklakov.SummaryTask4.core.user;

import java.util.List;

/**
 * Manager interface for User entity.
 * 
 * @author Oleg Soklakov
 *
 */
public interface UserManager {

	/**
	 * Get all doctors from database.
	 * 
	 * @return All doctors from database.
	 */
	List<User> getDoctors();

	/**
	 * Get pediatrician doctors.
	 * 
	 * @return The doctors with pediatrician specialization.
	 */
	List<User> getPediatricianDoctors();

	/**
	 * Get traumatologist doctors.
	 * 
	 * @return The doctors with traumatologist specialization.
	 */
	List<User> getTraumatologistDoctors();

	/**
	 * Get surgeon doctors.
	 * 
	 * @return The doctors with surgeon specialization.
	 */
	List<User> getSurgeonDoctors();

	/**
	 * Add user to database.
	 * 
	 * @param user
	 *            specified user.
	 */
	void addUser(User user);

	/**
	 * Get user by login
	 * 
	 * @param login
	 *            specified login.
	 * @return user who was found in database.
	 */
	User getUserByLogin(String login);

}
