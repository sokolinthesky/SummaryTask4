package ua.nure.soklakov.SummaryTask4.core.user;

import java.util.List;

/**
 * User dao interface. Contains all methods for user entity.
 * 
 * @author Oleg Soklakov
 *
 */
public interface UserDao {

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
	
	List<Role> getRoles();

	
	List<Specialization> getSpecializations();
}
