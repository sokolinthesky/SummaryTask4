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
	 * Get doctors by specialtyю
	 * 
	 * @param specializationId
	 * @return
	 */
	List<User> getDoctorsBySpecialization(int specializationId);

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
	
	User getUserById(int id);

	List<Role> getRoles();

	List<Specialization> getSpecializations();

}
