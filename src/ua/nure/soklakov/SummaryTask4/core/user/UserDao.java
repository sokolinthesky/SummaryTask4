package ua.nure.soklakov.SummaryTask4.core.user;

import java.util.List;

import ua.nure.soklakov.SummaryTask4.LoginDuplicateException;

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
	 *            specified specialization id.
	 * @return list of users.
	 */
	List<User> getDoctorsBySpecialization(int specializationId);

	/**
	 * Add user to database.
	 * 
	 * @param user
	 *            specified user.
	 */
	void addUser(User user) throws LoginDuplicateException;

	/**
	 * Get user by login
	 * 
	 * @param login
	 *            specified login.
	 * @return user who was found in database.
	 */
	User getUserByLogin(String login);

	/**
	 * Get user by id.
	 * 
	 * @param id
	 *            specified id.
	 * @return user entity.
	 */
	User getUserById(int id);

	/**
	 * Get all roles that can be used.
	 * 
	 * @return list of roles.
	 */
	List<Role> getRoles();

	/**
	 * Get all specializations that can be used.
	 * 
	 * @return list of specializations.
	 */
	List<Specialization> getSpecializations();
}
