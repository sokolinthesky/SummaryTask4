package ua.nure.soklakov.SummaryTask4.core.user;

import java.util.List;

import ua.nure.soklakov.SummaryTask4.LoginDublicateException;

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
	void addUser(User user) throws LoginDublicateException;

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
